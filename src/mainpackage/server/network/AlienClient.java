/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage.server.network;

/**
 *
 * @author Kunia
 */
import java.io.Serializable;
import java.util.function.Consumer;

public class AlienClient extends AlienConnectionFX{

    private String ip;
    private int port;

    public AlienClient(String ip, int port, Consumer<Serializable> onReceiveCallback) {
        super(onReceiveCallback);
        this.ip = ip;
        this.port = port;
    }

    @Override
    protected boolean isServer() {
        return false;
    }

    @Override
    protected String getIP() {
        return ip;
    }

    @Override
    protected int getPort() {
        return port;
    }
}
