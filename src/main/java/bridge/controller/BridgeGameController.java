package bridge.controller;

public class BridgeGameController {

    private int tryCount = 0;

    public void run() {
        try {
            tryCount += 1;
        } catch (IllegalArgumentException illegalArgumentException) {

        }
    }
}
