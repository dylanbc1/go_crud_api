
public class PrinterI implements Demo.Printer {

    public void printString(String msg, com.zeroc.Ice.Current current) {

        String[] msg_parts = msg.split(" ");

        String real_msg = msg_parts[1];
        try {
            int num = Integer.parseInt(real_msg);
            System.out.println(prime_factors(num));

        } catch (NumberFormatException e){
            boolean valid_msg = true;
            String[] real_msg_parts = null;

            if(real_msg.contains("listifs")){
                real_msg_parts = real_msg.split("listifs");
            } else if(real_msg.contains("listports")){
                real_msg_parts = real_msg.split("listports");
            } else if(real_msg.contains("!")){
                real_msg_parts = real_msg.split("!");
            } else {
                System.out.println("Ups! Type a valid message");
                valid_msg = false;
            }

            if(valid_msg){
                if(verify_msg(real_msg_parts)){
                    // execute commands in terminal
                } else {
                    System.out.println("Ups! Type a valid message");
                }
            }
        }
    }

    public String prime_factors(int num){
        return "";
    }

    public boolean verify_msg(String[] parts){
        if(parts[0].equalsIgnoreCase("")){
            return true;
        } else {
            return false;
        }
    }

}
