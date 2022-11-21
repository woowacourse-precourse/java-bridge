package bridge.mediator;

import bridge.controller.Controller;
import bridge.dto.BridgeStatusDto;
import bridge.view.ViewFaçade;

import java.util.HashMap;

public interface Mediator {

    void start();
    void generateBridge(int i);

    void moveBridge();

    Runnable moveBridge(String s, HashMap<String, String> map);

    void replay();

    void replay(String readGameCommand) ;

    void end(BridgeStatusDto bridgeStatusDto);
}
