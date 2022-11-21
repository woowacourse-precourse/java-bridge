package bridge.domain;

import bridge.view.ViewMaker;

public class User {

    private final ViewMaker viewMaker;

    public User(ViewMaker viewMaker) {
        this.viewMaker = viewMaker;
    }

    public CompareResult requestDirection(int bridgeLocation) {
        return this.viewMaker.receiveUserDirection(bridgeLocation);
    }

    public boolean requestGameCommand() {
        return this.viewMaker.receiveUserGameCommand();
    }

    public ViewMaker getViewMaker() {
        return viewMaker;
    }

}
