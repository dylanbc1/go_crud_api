import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int sent_request = 0;

        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "client.cfg")) {

            // twoway añadido, debe esperar respuesta
            Demo.PrinterPrx chatManagerPrx = Demo.PrinterPrx
                    .checkedCast(communicator.propertyToProxy("Printer.Proxy")).ice_twoway();

            try {
                String hostname = Inet4Address.getLocalHost().getHostName();
                String msg = "";
                String username = System.getProperty("user.name");

                while (!msg.equalsIgnoreCase("exit")){
                    String user_msg = reader.nextLine().trim();

                    Long start = System.currentTimeMillis();
                    sent_request += 1;

                    msg = chatManagerPrx.printString(username+":"+hostname+" "+ user_msg);

                    if(user_msg.equalsIgnoreCase("exit")){
                        break;
                    }

                    String latency_response = "\nLatency (response): " + (System.currentTimeMillis() - start) + "ms";
                    String requests = "\nSent requests (by this client): " + sent_request;
                    System.out.println(username + ":" + hostname + "\n"
                            + msg + latency_response + requests + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
