/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microtik;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
/**
 *
 * @author ricardo
 */
public class PPoEAuto {

    public void dhcpCliente(String host, String user, String password, String ether) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                try {
                    ApiConnection cn = ApiConnection.connect(host);
                    cn.login(user, password);
                    String command = "/ip/dhcp-client/add interface=" + ether + " disabled=no";
                    cn.execute(command);
                    mostrarMensaje("Ether1 configurada con IP dinámica para conexión a internet");
                    cn.close();
                } catch (Exception e) {
                    mostrarError("Error en módulo PPoE: " + e);
                }
                return null;
            }
        }.execute();
    }

    public void createBridge(String host, String user, String password, String bridge) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                try {
                    ApiConnection cn = ApiConnection.connect(host);
                    cn.login(user, password);
                    cn.execute("/interface/bridge/add name=" + bridge);
                    mostrarMensaje("Bridge: " + bridge + " creado con éxito");
                    cn.close();
                } catch (MikrotikApiException e) {
                    mostrarError("Error al crear el Bridge: " + e);
                } catch (Exception e) {
                    mostrarError("Error inesperado: " + e);
                }
                return null;
            }
        }.execute();
    }

    public void interfazABridge(String ether, String bridg, String user, String password, String host) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                try {
                    ApiConnection cn = ApiConnection.connect(host);
                    cn.login(user, password);

                    String comando = "/interface/bridge/port/add interface=" + ether + " bridge=" + bridg;
                    System.out.println(comando);
                    cn.execute(comando);

                    // Mostrar mensaje en el hilo de la UI
                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "Interfaz: " + ether + " agregada al bridge: " + bridg)
                    );

                    cn.close();
                } catch (Exception e) {
                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "Error inesperado: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE)
                    );
                    System.out.println(e);
                }
                return null;
            }
        };
        worker.execute();
    }

    public void agregarPool(String nombre, String rango, String user, String password, String host) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                try {
                    ApiConnection cn = ApiConnection.connect(host);
                    cn.login(user, password);

                    String comando = "/ip/pool/add name=" + nombre + " ranges=" + rango;
                    System.out.println(comando);
                    cn.execute(comando);

                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "Pool: " + nombre + " agregado con rango: " + rango)
                    );

                    cn.close();
                } catch (Exception e) {
                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "Error inesperado: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE)
                    );
                    System.out.println(e);
                }
                return null;
            }
        };
        worker.execute();
    }

    public void agregarServidorPPPoE(String serviceName, String interfaz, String user, String password, String host) {
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            // Agregar el servidor PPPoE
            String comando1 = "/interface/pppoe-server/server/add service-name=" + serviceName + " interface=" + interfaz;
            System.out.println(comando1);
            cn.execute(comando1);

            // Buscar el ID del servicio
            List<Map<String, String>> response = cn.execute("/interface/pppoe-server/server/print where service-name=" + serviceName);

            if (response.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontró el servicio PPPoE: " + serviceName);
            } else {
                // Obtener el ID del servicio
                String id = response.get(0).get(".id");

                // Habilitar el servicio PPPoE usando el ID
                String comando2 = "/interface/pppoe-server/server/set .id=" + id + " disabled=no";
                System.out.println(comando2);
                cn.execute(comando2);

                JOptionPane.showMessageDialog(null, "Servidor PPPoE: " + serviceName + " agregado y habilitado en la interfaz: " + interfaz);
            }

            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    public void crearPerfilPPPoE(String nombre, String localAddress, String remoteAddress, String rateLimit, String user, String password, String host) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                try {
                    ApiConnection cn = ApiConnection.connect(host);
                    cn.login(user, password);

                    String comando = "/ppp/profile/add name=" + nombre + " local-address=" + localAddress + " remote-address=" + remoteAddress + " address-list=Internet rate-limit=" + rateLimit;
                    System.out.println(comando);
                    cn.execute(comando);

                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "Perfil PPPoE: " + nombre + " creado correctamente.")
                    );

                    cn.close();
                } catch (Exception e) {
                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "Error inesperado: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE)
                    );
                    System.out.println(e);
                }
                return null;
            }
        };
        worker.execute();
    }

    public void crearClientePPPoE(String nombre, String contraseña, String perfil, String user, String password, String host) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                try {
                    ApiConnection cn = ApiConnection.connect(host);
                    cn.login(user, password);

                    String comando = "/ppp/secret/add name=" + nombre + " password=" + contraseña + " profile=" + perfil;
                    System.out.println(comando);
                    cn.execute(comando);

                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "Cliente PPPoE: " + nombre + " creado correctamente con contraseña: " + contraseña)
                    );

                    cn.close();
                } catch (Exception e) {
                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "Error inesperado: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE)
                    );
                    System.out.println(e);
                }
                return null;
            }
        };
        worker.execute();
    }

    public void aplicarReglasFirewall(String user, String password, String host) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                try {
                    ApiConnection cn = ApiConnection.connect(host);
                    cn.login(user, password);

                    String[] comandos = {
                        "/ip/firewall/filter/add chain=forward action=drop src-address-list=corte comment=corteDeInternet",
                        "/ip/firewall/filter/add chain=forward action=drop dst-address-list=corte comment=corteDeInternet",
//                        "/ip/firewall/nat/add chain=srcnat action=masquerade src-address-list=Internet",
//                        "/ip/firewall/nat/add chain=srcnat action=masquerade dst-address-list=Internet",
                        "/system/ntp/client/set enabled=yes servers=162.159.200.1,216.239.35.0",
                    };

                    for (String comando : comandos) {
                        cn.execute(comando);
                    }

                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "Address List corte, y Address List internet aplicadas con exito!")
                    );

                    cn.close();
                } catch (Exception e) {
                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "Error inesperado: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE)
                    );
                    System.out.println(e);
                }
                return null;
            }
        };
        worker.execute();
    }

    public void bloquearClientePPoE(String address, String user, String host, String password) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                try {
                    ApiConnection cn = ApiConnection.connect(host);
                    cn.login(user, password);
                    
                    String comando = "/ip/firewall/address-list/add list=corte address=" + address;
                    System.out.println(comando);
                    cn.execute(comando);

                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "El cliente con dirección IP: " + address + " fue bloqueado de manera exitosa")
                    );

                    cn.close();
                } catch (Exception e) {
                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, "Tenemos un problema al bloquear el cliente: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE)
                    );
                    System.out.println(e);
                }
                return null;
            }
        };
        worker.execute();
    }

    public void desbloquearCliente(String ipCliente, String user, String password, String host) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                try {
                    ApiConnection cn = ApiConnection.connect(host);
                    cn.login(user, password);

                    // Buscar la IP en la lista 'corte'
                    List<Map<String, String>> response = cn.execute("/ip/firewall/address-list/print where address=" + ipCliente + " and list=corte");

                    if (response.isEmpty()) {
                        mostrarMensaje("No se encontró la IP en la lista de bloqueo: " + ipCliente);
                    } else {
                        // Obtener el ID del registro y eliminarlo
                        String id = response.get(0).get(".id");
                        cn.execute("/ip/firewall/address-list/remove .id=" + id);
                        mostrarMensaje("Cliente con IP " + ipCliente + " desbloqueado correctamente.");
                    }

                    cn.close();
                } catch (Exception e) {
                    mostrarError("Error al desbloquear el cliente: " + e);
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    private void mostrarMensaje(String mensaje) {
        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, mensaje));
    }

    private void mostrarError(String mensaje) {
        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, mensaje, "SpiderNET", JOptionPane.ERROR_MESSAGE));
    }

    public void editarPPPoESecret(String nombreActual, String nombreNuevo, String nuevaContrasena, String nuevoPerfil, String user, String password, String host) {
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            // Buscar el usuario PPPoE usando el nombre actual
            List<Map<String, String>> response = cn.execute("/ppp/secret/print where name=" + nombreActual);

            if (response.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontró el usuario PPPoE: " + nombreActual);
            } else {
                // Obtener el ID del usuario
                String id = response.get(0).get(".id");

                // Ejecutar el comando para editar el PPPoE secret
                String comando = "/ppp/secret/set .id=" + id + " name=" + nombreNuevo + " password=" + nuevaContrasena + " profile=" + nuevoPerfil;
                cn.execute(comando);

                JOptionPane.showMessageDialog(null, "Usuario PPPoE: " + nombreActual + " editado correctamente.");
            }

            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar el usuario PPPoE: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void actualizarProfilePorIP(String ip, String nuevoPerfil, String user, String password, String host) {
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(user, password);

            // Buscar el usuario PPPoE usando la dirección IP en lugar del nombre
            List<Map<String, String>> response = cn.execute("/ppp/secret/print where remote-address=" + ip);

            if (response.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontró el usuario PPPoE con IP: " + ip);
            } else {
                // Obtener el ID del usuario
                String id = response.get(0).get(".id");

                // Ejecutar el comando para editar el PPPoE secret y cambiar su perfil
                String comando = "/ppp/secret/set .id=" + id + " profile=" + nuevoPerfil;
                cn.execute(comando);

                JOptionPane.showMessageDialog(null, "Usuario PPPoE con IP " + ip + " actualizado al perfil " + nuevoPerfil);
            }

            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario PPPoE: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void eliminarSecret(String name, String username, String password, String host){
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(username, password);
            
            String comando = "/ppp/secret/remove numbers=" + name;
            
            System.out.println("Comando enviado " + comando);
            cn.execute(comando);
            JOptionPane.showMessageDialog(null, "Secret eliminado exitosamente");
            cn.close();
        } catch (Exception e) {
            System.out.println("Problemas al eliminar el secret: "  + e);
            JOptionPane.showMessageDialog(null, "Problemas al eliminar el secret " + e);
        }
    }
    
    public void updateSecret(String id,String nameNuevo, String passwordNuevo, String paqueteNuve, String username, String password, String host){
        try {
            ApiConnection cn = ApiConnection.connect(host);
            cn.login(username, password);
            String comando = "/ppp/secret/set numbers=" +id + " name=" + nameNuevo + " password="+passwordNuevo + " profile="+paqueteNuve;
            System.out.println("Comando enviado: " + comando);
            cn.execute(comando);
            JOptionPane.showMessageDialog(null, "El usuario se actualizo con exito");
            cn.close();
        } catch (Exception e) {
            System.out.println("Problemas con ejecutar el comando: " + e);
            JOptionPane.showMessageDialog(null, "Tenemos problemas con la actualizacion: " + e);
        }
    }
}
