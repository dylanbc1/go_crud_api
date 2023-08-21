import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrinterI implements Demo.Printer {
    // añadimos communicator para cerrar el server
    Communicator communicator;
    long start_time;

    PrinterI(Communicator communicator){
        this.communicator = communicator;
    }

    public void printString(String msg, com.zeroc.Ice.Current current) {
        System.out.println("\nExecuting -> " + msg);
        start_time = System.currentTimeMillis();

        String[] msg_parts = msg.split(" ");

        if(msg_parts[1].equalsIgnoreCase("exit")){
            communicator.shutdown();
        }

        String real_msg = msg_parts[1];

        try {
            int num = Integer.parseInt(real_msg);
            prime_factors(num);

        } catch (NumberFormatException e){
            boolean valid_msg = true;
            String[] real_msg_parts = null;
            String msg_type = "";

            if(real_msg.contains("listifs")){
                real_msg_parts = real_msg.split("listifs");
                msg_type = "listifs";
            } else if(real_msg.contains("listports")){
                real_msg_parts = (real_msg + msg_parts[2]).split("listports");
                msg_type = "listports";
            } else if(real_msg.contains("!")){
                real_msg_parts = (real_msg + " " + msg_parts[2]).split("!");
                msg_type = "!";
            } else if(real_msg.equalsIgnoreCase("exit")){
                msg_type = "exit";
            } else {
                System.out.println("Ups! Type a valid message");
                valid_msg = false;
            }

            if(valid_msg && !msg_type.equalsIgnoreCase("exit")){
                if(verify_msg(real_msg_parts, msg_type)){
                    execute_command(real_msg_parts, msg_type);
                } else {
                    System.out.println("Ups! Type a valid message");
                }
            }
        }
    }

    public void prime_factors(int num){
        String msg = "";

        while (num % 2 == 0) {
            // msg += 2 + " ";
            System.out.println(2 + " ");
            num /= 2;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                // msg += i + " ";
                System.out.println(i + " ");
                num /= i;
            }
        }

        if (num > 2) {
            // msg += num;
            System.out.println(num);
        }

        finished();
    }

    public boolean verify_msg(String[] real_msg_parts, String msg_type){
        switch (msg_type){
            case "listifs":
                return (real_msg_parts.length == 0);
            case "listports":
                if(real_msg_parts.length == 2){
                    return (real_msg_parts[1].split(" ").length == 1);
                } else {
                    return false;
                }
            case "!":
                return (real_msg_parts.length == 2);
            default:
                return false;
        }

        /*
        if(real_msg_parts[0].equalsIgnoreCase("")){
            return true;
        } else {
            return false;
        }*/
    }

    private void execute_command(String[] real_msg_parts, String msg_type){
        try {
            if(msg_type.equalsIgnoreCase("listifs")){
                command("ifconfig");
            } else if(msg_type.equalsIgnoreCase("listports")){
                String ip = real_msg_parts[1].split(" ")[0];
                command("nmap " + ip);
            } else {
                command(real_msg_parts[1]);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void command(String command) throws IOException {
        Process process = Runtime.getRuntime().exec("cmd /c " + command);
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String resultExecution;
        while ((resultExecution = br.readLine()) != null) {
            System.out.println(resultExecution);
        }
        finished();
    }

    private void finished(){
        long final_time = System.currentTimeMillis();
        long latency = final_time - start_time;
        System.out.println("Latency: " + latency +  "ms");
    }
}
