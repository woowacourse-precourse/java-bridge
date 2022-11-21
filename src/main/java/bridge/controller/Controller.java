package bridge.controller;

import bridge.view.ViewFaçade;

import java.util.HashMap;

public interface Controller {
    Runnable generateBridge(ViewFaçade viewFaçade, int size);

    Runnable moveBridge(String readLine, HashMap<String, String> map);

    Runnable replay(String readLine);
}
