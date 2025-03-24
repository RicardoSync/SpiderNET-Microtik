package activacion;

import java.net.NetworkInterface;
import java.net.InetAddress;
import java.util.Enumeration;

public class ProcesadorID {

    public static String obtenerIdDiscoDuro() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface network = interfaces.nextElement();
                byte[] mac = network.getHardwareAddress();

                if (mac != null) {
                    StringBuilder macAddress = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        macAddress.append(String.format("%02X", mac[i]));
                        if (i < mac.length - 1) {
                            macAddress.append("-");
                        }
                    }
                    System.out.println("MAC Address: " + macAddress);
                    break;  // Tomamos la primera MAC válida y salimos
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("ID del disco duro: " + obtenerIdDiscoDuro());
    }
}
