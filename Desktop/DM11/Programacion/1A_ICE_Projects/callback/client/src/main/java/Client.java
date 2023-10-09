import Demo.CallbackReceiverPrx;
import Demo.CallbackSenderPrx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.Arrays;
import Demo.PrinterPrx;
import com.zeroc.Ice.Util;
import Demo.*;

public class Client {
    // el cliente tiene referencia del server a través de los proxy, por eso necesito referenciar a sender
    // necesitamos referencia del server. El server config configura all el server
    // Los nombres de los adapter deben ser iguales cuando referencio !!!
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sent_request = 0;

        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "config.client")) {
            communicator.getProperties().setProperty("Ice.Default.Package",
                    "com.zeroc.demos.Ice.callback");

            // callback prx (sender)
            CallbackSenderPrx callbackSenderPrx = CallbackSenderPrx.checkedCast(
                    communicator.propertyToProxy("CallbackSender.Proxy")).ice_twoway();

            // chat manager para enviar msj
            // Demo.PrinterPrx chatManagerPrx = Demo.PrinterPrx
            //        .checkedCast(communicator.propertyToProxy("Printer.Proxy")).ice_twoway();

            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapter("Callback.Client");
            adapter.add(new CallbackReceiverI(), com.zeroc.Ice.Util.stringToIdentity("callbackReceiver"));
            adapter.activate();

            // callback prx (receiver)
            CallbackReceiverPrx receiver =
                    CallbackReceiverPrx.uncheckedCast(adapter.createProxy(
                            com.zeroc.Ice.Util.stringToIdentity("callbackReceiver")));

            try {
                String hostname = Inet4Address.getLocalHost().getHostName();
                String msg = "";
                String username = System.getProperty("user.name");

                // inicia el callback
                callbackSenderPrx.initiateCallback(hostname, receiver);

                while (!msg.equalsIgnoreCase("exit")){
                    String user_msg = reader.readLine();

                    Long start = System.currentTimeMillis();
                    sent_request += 1;

                    // enviar string al server
                    callbackSenderPrx.messageToHostname(receiver, "localhost", user_msg);

                    if(user_msg.equalsIgnoreCase("exit")){
                        break;
                    }

                    String latency_response = "\nLatency (response | less the 1000ms of testing throughput): " + (System.currentTimeMillis() - start - 1000) + "ms";
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
