package bridge.controller;

import bridge.view.ViewFaçade;

import java.util.HashMap;

public interface Controller {
    Runnable generateBridge (int size);

    Runnable moveBridge(String direction, HashMap<String, String> map);

    Runnable replay(String restartCommand);
}
