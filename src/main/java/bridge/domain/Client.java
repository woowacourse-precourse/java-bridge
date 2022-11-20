package bridge.domain;

import bridge.view.ViewMaker;

public class Client {
    public static void requestBridgeConstruction(final ViewMaker viewMaker) {
        viewMaker.receiveClientRequest();
    }

    public static User introduceGameUser(ViewMaker viewMaker) {
        return new User(viewMaker);
    }

}
