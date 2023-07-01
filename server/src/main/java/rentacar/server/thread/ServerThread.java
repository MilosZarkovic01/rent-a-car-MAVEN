/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.server.thread;

import rentacar.server.controller.Controller;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rentacar.common_lib.settings.ConnectionConfig;

/**
 *
 * @author Somika
 */
public class ServerThread extends Thread {

    private final ServerSocket serverSocket;
    private List<ClientThread> clients;
    private boolean serverRunning;

    public ServerThread() throws IOException {
        this.serverRunning = true;
        clients = new ArrayList<>();
        serverSocket = new ServerSocket(readPortNumber());
        start();
    }

    @Override
    public void run() {
        try {
            Controller.getInstance().getMainForm().setStatus("Server is running on port: " + readPortNumber(), false);
            Socket socket;
            while (serverRunning) {
                socket = serverSocket.accept();
                ClientThread client = new ClientThread(socket);
                clients.add(client);
            }
        } catch (IOException ex) {
            System.out.println("Server is down!");
        }
    }

    public void stopServer() {
        try {
            for (ClientThread client : clients) {
                client.setSignal(false);
                client.getSocket().close();
            }
            clients = new ArrayList<>();
            //Controller.getInstance().setActiveAdmins(new ArrayList<>());
            serverRunning = false;
            serverSocket.close();
            Controller.getInstance().getMainForm().prepareTable();
            Controller.getInstance().getMainForm().setStatus("Server stopped!", true);
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int readPortNumber() {
        return Integer.parseInt(ConnectionConfig.getInstance().getProperty("port"));
    }
}
