package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.view.InputView;

import java.util.List;

public class BridgeController {
    public void run() {
        InputView inputView = new InputView();
        try{
            inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
