package bridge.domain.controller;

import bridge.constants.GuideMessage;
import bridge.domain.model.Bridge;
import bridge.domain.model.CrossBridge;
import bridge.domain.view.InputView;
import bridge.domain.view.OutputView;

public class BridgeGameProgram {

    private final String SUCCESS = "성공";
    //model
    Bridge bridge = new Bridge();
    //view
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    //controller
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame = new BridgeGame();
    CrossBridge crossBridge = new CrossBridge();

    private boolean go = true;

    public BridgeGameProgram() {

    }

    public void game() {
        try {
            outputView.printGuideMessage(GuideMessage.START_MESSAGE);
            getBridgeLength();
            goGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getBridgeLength() {
        outputView.printGuideMessage(GuideMessage.INPUT_LENGTH_MESSAGE);
        int bridgeLength = inputView.readBridgeLength();
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeLength));

        if (bridge.getSize() != bridgeLength) {
            throw new IllegalArgumentException("service error");
        }
    }

    public void goGame() {
        while (go) {
            oneGame();
            if (crossBridge.getSuccess().equals(SUCCESS)) {
                outputView.printResult();
                break;
            }
            restart();
        }
    }

    public void oneGame() {
        crossBridge.setNewGame();
        while (!crossBridge.isEnd()) {
            String moving = move();
            if (!crossBridge.isCurrentValid(moving)) {
                break;
            }
        }
    }

    public String move() {
        outputView.printGuideMessage(GuideMessage.INPUT_MOVE_MESSAGE);
        String moving = inputView.readMoving();
        bridgeGame.move(moving);
        outputView.printMap();
        return moving;
    }
}
