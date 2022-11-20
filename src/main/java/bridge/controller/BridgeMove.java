package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.model.Bridge;
import bridge.model.BridgeShape;
import bridge.model.GameControll;
import bridge.service.Valification;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.controller.GameController.controllMove;
import static bridge.controller.GameResultPrint.showNowBridgeShape;

public class BridgeMove {

    private final InputView inputView = new InputView();
    private final Valification valification = new Valification();
    private final OutputView outputView = new OutputView();
    private final GameControll gameControll = new GameControll();
    private final BridgeShape bridgeShape = new BridgeShape();
    private final BridgeGame bridgeGame = new BridgeGame();

    private String move;

    public void movebridge(){
        viewMove();
        checkMoveBridge();
        plusOneStep();
        makeBirdgeShape();
        showNowBridgeShape();
        controllMove();
    }

    private void viewMove(){
        outputView.printRequestMove();
        move = inputView.readMoving();
        valification.verifyUorD(move);
    }

    private void checkMoveBridge(){
        bridgeGame.move(move, gameControll.getIdx(), Bridge.getBridge());
    }

    private void plusOneStep(){
        gameControll.plusIdx();
    }

    private void makeBirdgeShape(){
        bridgeShape.moveBridge(move, bridgeGame.getCanMove());
    }
}
