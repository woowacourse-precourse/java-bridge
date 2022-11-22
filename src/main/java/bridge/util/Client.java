package bridge.util;

import bridge.domain.User;
import bridge.view.ViewMaker;

public final class Client {

    private Client() {
    }

    public static void requestBridgeConstruction(final ViewMaker viewMaker) {
        viewMaker.receiveClientRequest();
    }

    public static User introduceGameUser(final ViewMaker viewMaker) {
        return new User(viewMaker);
    }

}
