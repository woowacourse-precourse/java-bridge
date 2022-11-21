package bridge.controller;

import bridge.view.ViewFaçade;

import java.util.HashMap;

public interface Controller {
    Runnable generateBridge(ViewFaçade viewFaçade, int size);

    Runnable moveBridge(ViewFaçade viewFaçade, String readLine, HashMap<String, String> map);

    Runnable replay(ViewFaçade viewFaçade, String readLine);
}
