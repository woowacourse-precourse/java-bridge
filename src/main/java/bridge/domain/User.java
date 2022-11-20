package bridge.domain;

import bridge.view.ViewMaker;

public class User {

    private final ViewMaker viewMaker;

    public User(ViewMaker viewMaker) {
        this.viewMaker = viewMaker;
    }

    public void requestDirection(int bridgeLocation) {
        this.viewMaker.receiveUserDirection(bridgeLocation);
    }

}
