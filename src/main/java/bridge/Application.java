package bridge;

import bridge.client.Client;

public class Application {

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
