module Demo
{
    interface Printer
    {
        string printString(string s);

    }

    interface CallbackReceiver
    {
        void callback(string msg);
    }
    interface CallbackSender
    {
        void messageToHostname(CallbackReceiver* proxy, string hostname, string msg);
        void initiateCallback(string hostname, CallbackReceiver* proxy);
        void shutdown();
    }
}