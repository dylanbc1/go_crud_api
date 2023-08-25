import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

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

                    msg = chatManagerPrx.printString(username+":"+hostname+" "+ user_msg);

                    if(user_msg.equalsIgnoreCase("exit")){
                        break;
                    }

                    String latency_response = "Latency (response): " + (System.currentTimeMillis() - start) + "ms";
                    System.out.println(username + ":" + hostname + "\n" + msg + "\n" + latency_response + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
