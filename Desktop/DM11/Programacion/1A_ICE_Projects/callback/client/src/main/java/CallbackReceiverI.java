//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
import Demo.CallbackReceiver;

public final class CallbackReceiverI implements CallbackReceiver
{
    @Override
    public void callback(String msg, com.zeroc.Ice.Current current)
    {
        System.out.println(msg);
    }
}