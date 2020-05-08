/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage.server.mainserver;

import java.io.Serializable;
import java.util.function.Consumer;
import mainpackage.server.network.AlienConnectionFX;

public class ServerFX extends AlienConnectionFX {

    private int port;

    public ServerFX(int port, Consumer<Serializable> onReceiveCallback) {
        super(onReceiveCallback);
        this.port = port;
    }
    
    @Override
    protected boolean isServer() {
        return true;
    }

    @Override
    protected String getIP() {
        return null;
    }

    @Override
    protected int getPort() {
        return port;
    }
}
