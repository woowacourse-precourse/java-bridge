package bridge;

import bridge.connector.Connector;

public class Application {

    public static void main(String[] args) {
        Connector connector = new Connector();
        connector.playBridge();
    }
}
