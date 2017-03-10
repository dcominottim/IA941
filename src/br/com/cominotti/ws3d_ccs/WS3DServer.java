package br.com.cominotti.ws3d_ccs;

import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class WS3DServer {

    private WS3DServer() {
        //
    }


    public static void start() {
        try {
            Executors.newSingleThreadExecutor().submit(() -> worldserver3d.Main.main(null));
            Thread.sleep(6000);
        } catch (Exception ex) {
            Logger.getLogger(WS3DServer.class.getName()).severe(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
