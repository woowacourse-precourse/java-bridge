package bridge.engine.state;

public interface BridgeState {

    void start();
    boolean move();
    boolean retry();
    void end();
}
