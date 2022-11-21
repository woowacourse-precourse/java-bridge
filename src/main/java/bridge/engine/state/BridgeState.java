package bridge.engine.state;

import bridge.engine.reporter.BridgeResult;

public interface BridgeState {

    void start(int size);
    boolean move(String direction);
    boolean retry(String command);
    BridgeResult end();
}
