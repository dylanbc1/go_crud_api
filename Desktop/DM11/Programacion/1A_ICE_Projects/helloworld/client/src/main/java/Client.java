import java.net.Inet4Address;
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

                while (!msg.equals("exit")){
                    msg = reader.nextLine().trim();
                    msg = chatManagerPrx.printString(username+":"+hostname+" "+msg);
                    System.out.println(username+":"+hostname+" "+msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
