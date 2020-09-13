package Networking;

import java.util.Vector;

public class Address {
    public static Vector<Integer> port1 = new Vector<Integer>();
    public static Vector<Integer> port2 = new Vector<Integer>();
    public static Vector<Integer> port3 = new Vector<Integer>();
    public static Vector<Integer> port4 = new Vector<Integer>();
    public static Vector<String> ip = new Vector<String>();
    public static Vector<String> name = new Vector<String>();

    public Address(Integer port1, Integer port2, String ip) {
        Address.port1.add(port1);
        Address.port2.add(port2);
        Address.ip.add(ip);
    }
}
