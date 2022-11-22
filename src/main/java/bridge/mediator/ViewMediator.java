package bridge.mediator;

import java.util.HashMap;

public interface ViewMediator {
    void start();
    void generateBridge(int i);

    Runnable moveBridge(String s, HashMap<String, String> map);

    void replay(String readGameCommand) ;
}
