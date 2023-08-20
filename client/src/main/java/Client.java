import java.net.Inet4Address;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "client.cfg")) {

            Demo.PrinterPrx chatManagerPrx = Demo.PrinterPrx
                    .checkedCast(communicator.propertyToProxy("Printer.Proxy"));

            try {
                String hostname = Inet4Address.getLocalHost().getHostName();
                System.out.println("hostname: " + hostname);
                String msg = "";
                String username = System.getProperty("user.name");

                while (!msg.equals("exit")){
                    msg = reader.nextLine();
                    chatManagerPrx.printString(username+"/"+hostname+": "+msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
