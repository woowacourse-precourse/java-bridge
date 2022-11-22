package bridge.controller;

import bridge.*;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final String SUCCESS = "성공";
    private final String FAILURE = "실패";
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private BridgeGame bridgeGame;
    private String resultOfGame;
    private int bridgeSize;

    public void startGame() {
        setUpBridgeGame();
        proceedBridgeGame();
        outputView.printResult(bridgeGame.getUserMoving(), resultOfGame, bridgeGame.getAttemptCount());
    }

    public void setUpBridgeGame() {
        List<String> bridge;

        inputBridgeSize();
        bridge = bridgeMaker.makeBridge(this.bridgeSize);
        //실행 예시와 맞추기 위해 한 칸 띄워준다.
        System.out.println();
        bridgeGame = new BridgeGame(bridge);
    }

    public void inputBridgeSize(){
        try{
            this.bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException e){
            System.out.println(e);
            inputBridgeSize();
        }
    }

    public void proceedBridgeGame() {
        while (true) {
            bridgeGame.resetUserMoving();
            bridgeGame.addAttemptCount();
            //System.out.println(bridgeGame.getBridge());
            proceedMove();

            if (decideEndOfGame()) break;
        }
    }

    public boolean decideEndOfGame() {
        if (bridgeGame.isSuccess()) {
            resultOfGame = SUCCESS;
            return true;
        }
        // 성공 하지도 못했는데 재시작도 안하면 실패
        if (bridgeGame.retry(inputView.readGameCommand()) == false) {
            resultOfGame = FAILURE;
            return true;
        }
        return false;
    }

    public void proceedMove() {
        while (true) {
            if (move() == false || bridgeGame.isEndOfBridge() == true) {
                outputView.printMap(bridgeGame.getUserMoving());
                break;
            }
            outputView.printMap(bridgeGame.getUserMoving());
        }
    }

    public boolean move() {
        String moving;
        boolean resultOfMove;

        moving = inputView.readMoving();
        resultOfMove = bridgeGame.move(moving);

        return resultOfMove;
    }
}
