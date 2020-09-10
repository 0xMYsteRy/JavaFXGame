package Networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddress {
    public static String getIPAddress(){
        InetAddress ip = null;

        try {

            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        assert ip != null;
        return ip.getHostAddress().toString();
    }
    //Testing
    public static void main(String[] args) {
        IPAddress ipAddress = new IPAddress();
    }
}
