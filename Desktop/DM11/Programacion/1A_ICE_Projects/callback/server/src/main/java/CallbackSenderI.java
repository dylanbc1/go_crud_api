// Copyright (c) ZeroC, Inc. All rights reserved.
//

import Demo.CallbackReceiver;
import Demo.CallbackReceiverPrx;
import Demo.CallbackSender;
import com.zeroc.Ice.Current;

import java.util.HashMap;

public class CallbackSenderI implements CallbackSender
{
    HashMap<String, CallbackReceiverPrx> clients = new HashMap<>();

    @Override
    public void messageToHostname(CallbackReceiverPrx proxy, String hostname, String msg, Current current) {
     proxy.callback(msg);
    }

    @Override
    public void initiateCallback(String hostname, CallbackReceiverPrx proxy, com.zeroc.Ice.Current current)
    {
        clients.put(hostname, proxy);
    }

    @Override
    public void shutdown(com.zeroc.Ice.Current current)
    {
        System.out.println("Shutting down...");
        try
        {
            current.adapter.getCommunicator().shutdown();
        }
        catch(com.zeroc.Ice.LocalException ex)
        {
            ex.printStackTrace();
        }
    }
}
