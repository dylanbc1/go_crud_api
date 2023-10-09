import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.OutputStream;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PrinterI implements Demo.Printer {
    private static final Logger logger = Logger.getLogger(PrinterI.class.getName());
    private final Set<String> registeredClients = new HashSet<>();

    // añadimos communicator para cerrar el server
    Communicator communicator;
    long start_time;
    long latency_process;
    int requests_received;
    int requests_answered;
    String msg;

    PrinterI(Communicator communicator) {
        this.communicator = communicator;
    }

    public String printString(String msg, Current current) {
        requests_received += 1;
        this.msg = msg;

        System.out.println("\nExecuting -> " + msg);
        start_time = System.currentTimeMillis();

        String[] msg_parts = msg.split(" ");
        System.out.println(msg_parts[0]);
        registerClient(msg_parts[0]);

        if (msg_parts.length == 1) {
            latency_process = System.currentTimeMillis() - start_time;
            requests_answered += 1;
            return ("Ups! Type a valid message" + get_performance());
        }


        if (msg_parts[1].equalsIgnoreCase("exit")) {
            communicator.shutdown();
        }

        String real_msg = msg_parts[1];

        try {
            Long num = Long.parseLong(real_msg);

            if (num <= 0 || msg_parts.length >= 3) {
                latency_process = System.currentTimeMillis() - start_time;
                requests_answered += 1;
                return ("Ups! Type a valid number" + get_performance());
            }

            String prime = prime_factors(num);
            latency_process = System.currentTimeMillis() - start_time;
            requests_answered += 1;
            System.out.println("Solicitud completada: " + msg);
            return prime + get_performance();
        } catch (NumberFormatException e) {
            String[] real_msg_parts = null;
            String msg_type = "";
            if (real_msg.startsWith("list") && msg_parts[2].equals("clients")){
                requests_answered += 1;
                latency_process = System.currentTimeMillis() - start_time;
                String clientsList = getListOfRegisteredClients();
                return ("Enviando lista de clientes: " + clientsList) + get_performance();
            }

            if (real_msg.startsWith("listifs")) {
                real_msg_parts = real_msg.split("listifs");
                msg_type = "listifs";
            } else if (real_msg.startsWith("listports")) {
                real_msg_parts = (real_msg + msg_parts[2]).split("listports");
                msg_type = "listports";

            } else if (real_msg.startsWith("!")) {
                if (msg_parts.length >= 3) {
                    String acc = "";

                    for (int i = 2; i < msg_parts.length; i++) {
                        acc = (real_msg + " " + msg_parts[i]);
                    }

                    real_msg_parts = acc.split("!");
                } else {
                    real_msg_parts = (real_msg).split("!");
                }
                msg_type = "!";
            } else if (real_msg.equalsIgnoreCase("exit")) {
                msg_type = "exit";
            } else {
                requests_answered += 1;
                latency_process = System.currentTimeMillis() - start_time;
                return ("Ups! Type a valid message" + get_performance());
            }

            if (!msg_type.equalsIgnoreCase("exit")) {
                if (verify_msg(real_msg_parts, msg_type)) {
                    requests_answered += 1;
                    return execute_command(real_msg_parts, msg_type);
                } else {
                    requests_answered += 1;
                    latency_process = System.currentTimeMillis() - start_time;
                    return ("Ups! Type a valid message") + get_performance();
                }
            }
        }

        requests_answered += 1;
        latency_process = System.currentTimeMillis() - start_time;
        return ("Ups! Type a valid message" + get_performance());
    }

    public String prime_factors(Long num) {
        String msg = "";

        while (num % 2 == 0) {
            // sout(2 + " ");
            msg += (2 + " ");
            num /= 2;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                msg += i + " ";
                num /= i;
            }
        }

        if (num > 2) {
            msg += num;
        }

        return msg;
    }

    public boolean verify_msg(String[] real_msg_parts, String msg_type) {
        switch (msg_type) {
            case "listifs":
                return (real_msg_parts.length == 0);
            case "listports":
                if (real_msg_parts.length == 2) {
                    return (real_msg_parts[1].split(" ").length == 1);
                } else {
                    return false;
                }
            case "!":
                return (real_msg_parts.length == 2);
            default:
                return false;
        }
    }

    private String execute_command(String[] real_msg_parts, String msg_type) {
        try {
            if (msg_type.equalsIgnoreCase("listifs")) {
                return command("ifconfig");
            } else if (msg_type.equalsIgnoreCase("listports")) {
                String ip = real_msg_parts[1].split(" ")[0];
                return command("nmap " + ip);
            } else {
                return command(real_msg_parts[1]);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private String command(String command) throws IOException {
        String result = "";
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String resultExecution;
        while ((resultExecution = br.readLine()) != null) {
            result += resultExecution + "\n";
        }

        latency_process = System.currentTimeMillis() - start_time;
        return (result + get_performance());
    }

    private String get_performance() {
        return get_requestes_received() + get_requests_answered() + get_latency_process() + get_throughput();
    }

    private String get_requests_answered() {
        return ("\nUnprocessed rate: " + (requests_received - requests_answered));
    }

    private String get_requestes_received() {
        return ("\nRequests received (server): " + requests_received);
    }

    private String get_latency_process() {
        return ("\nLatency (process): " + latency_process + "ms");
    }

    private String get_throughput() {
        long start_time = System.currentTimeMillis();
        int executed_commands = 0;
        String r;

        while (true) {
            // Simular el procesamiento del comando por parte del servidor
            r = printString2(msg);
            if (System.currentTimeMillis() - start_time >= 1000) {
                break;
            }
            executed_commands++;
        }

        return ("\nThroughput (of this command): " + executed_commands);
    }

    // testing throughput
    public String printString2(String msg) {
        String[] msg_parts = msg.split(" ");

        if (msg_parts.length == 1) {
            return ("Ups! Type a valid message");
        }

        String real_msg = msg_parts[1];

        try {
            Long num = Long.parseLong(real_msg);

            if (num <= 0) {
                return ("Ups! Type a valid number");
            }

            return prime_factors(num);
        } catch (NumberFormatException e) {
            String[] real_msg_parts = null;
            String msg_type = "";

            if (real_msg.startsWith("listifs")) {
                real_msg_parts = real_msg.split("listifs");
                msg_type = "listifs";
            } else if (real_msg.startsWith("listports")) {
                real_msg_parts = (real_msg + msg_parts[2]).split("listports");
                msg_type = "listports";
            } else if (real_msg.startsWith("!")) {
                if (msg_parts.length >= 3) {
                    String acc = "";

                    for (int i = 2; i < msg_parts.length; i++) {
                        acc = (real_msg + " " + msg_parts[i]);
                    }

                    real_msg_parts = acc.split("!");
                } else {
                    real_msg_parts = (real_msg).split("!");
                }
                msg_type = "!";
            } else if (real_msg.equalsIgnoreCase("exit")) {
                msg_type = "exit";
            } else {
                return ("Ups! Type a valid message");
            }

            if (!msg_type.equalsIgnoreCase("exit")) {
                if (verify_msg(real_msg_parts, msg_type)) {
                    return execute_command2(real_msg_parts, msg_type);
                } else {
                    return ("Ups! Type a valid message");
                }
            }
        }
        return ("Ups! Type a valid message");
    }

    // testing throughput
    private String execute_command2(String[] real_msg_parts, String msg_type) {
        try {
            if (msg_type.equalsIgnoreCase("listifs")) {
                return command2("ifconfig");
            } else if (msg_type.equalsIgnoreCase("listports")) {
                String ip = real_msg_parts[1].split(" ")[0];
                return command2("nmap " + ip);
            } else {
                return command2(real_msg_parts[1]);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    // testing throughput
    private String command2(String command) throws IOException {
        String result = "";
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String resultExecution;
        while ((resultExecution = br.readLine()) != null) {
            result += resultExecution + "\n";
        }

        return (result);
    }

    public void registerClient(String clientHostname) {
        synchronized (registeredClients) {
            registeredClients.add(clientHostname);
        }
    }

    public String getListOfRegisteredClients() {
        StringBuilder clientsList = new StringBuilder("Clientes registrados: ");
        synchronized (registeredClients) {
            for (String client : registeredClients) {
                clientsList.append(client).append(", ");
            }
        }
        // Elimina la coma y el espacio final
        if (clientsList.length() > 0) {
            clientsList.setLength(clientsList.length() - 2);
        }
        return clientsList.toString();
    }
}
