package bridge.controller;

import bridge.model.Bridge;
import bridge.model.Moving;
import bridge.model.Score;
import bridge.model.User;
import bridge.view.OutputView;

public class GameManager {
    BridgeInputController bridgeInputController;
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;

    OutputView outputView = new OutputView();
    public GameManager(BridgeInputController bridgeInputController, BridgeMaker bridgeMaker,
                       BridgeGame bridgeGame) {
        this.bridgeInputController = bridgeInputController;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    public void initGame() {
        int size = bridgeInputController.enterBridgeSize();
        bridgeGame.initBridge(bridgeMaker.makeBridge(size));

    }

    public void playGame() {
        User user = new User();
        Score score = new Score();

        while (checkMove(user, score)) {
            //출력하는 함수
        }
        //정답 못맞춘 경우

    }

    public boolean checkMove(User user, Score score){
        String command = bridgeInputController.enterUserMoving();
        if (bridgeGame.move(user.addUserCommand(command))){
            System.out.println(score.addGameResult(Moving.can.getMovingResult()));
            return true;
            }
        System.out.println(score.addGameResult(Moving.cant.getMovingResult()));
        return false;
    }

}
