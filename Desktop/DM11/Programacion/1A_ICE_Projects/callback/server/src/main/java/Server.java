import com.zeroc.Ice.*;
import com.zeroc.IceInternal.Incoming;
import java.lang.Exception;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) {
        System.out.println("SERVIDOR ABIERTO");
        //InitializationData initData = new InitializationData();
        //initData.properties = Util.createProperties(args);
        //initData.properties.setProperty("Ice.ThreadPool.Server.Size", "50");

        java.util.List<String> extraArgs = new java.util.ArrayList<String>();

        try (Communicator communicator = Util.initialize(args,"config.server", extraArgs)) {
            // communicator con propiedades de callback
            communicator.getProperties().setProperty("Ice.Default.Package",
                    "com.zeroc.demos.Ice.callback");

            // adapter para recibir msjes
            ObjectAdapter adapter = communicator.createObjectAdapter(
                    "Callback.Service");

            adapter.add(new CallbackSenderI(), com.zeroc.Ice.Util.stringToIdentity("callbackSender"));
            adapter.activate();
            // adapter para recibir callback
            // ObjectAdapter adapter2 = communicator.createObjectAdapterWithEndpoints(
            //        "Service", "default -p 9000");

            System.out.println("El servidor está listo para recibir solicitudes.");

            communicator.waitForShutdown();
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
