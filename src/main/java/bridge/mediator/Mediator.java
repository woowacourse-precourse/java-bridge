package bridge;

import bridge.controller.Controller;
import bridge.view.ViewFaçade;

import java.util.HashMap;

public interface Mediator {

    void generateBridge();


    void moveBridge();

    void replay();
}
