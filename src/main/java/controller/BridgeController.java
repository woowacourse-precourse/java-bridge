package controller;

import bridge.*;

import java.util.List;

public class BridgeController {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    InputView inputView = new InputView();
    BridgeGame bridgeGame = new BridgeGame();
    OutputView outputView = new OutputView();
    List<String> bridge;

    public void startGame(){
        bridgeGame.addGameCount();

        if(!repeatSuccess()) {
            askRetryGame();
            return;
        }
        outputView.printResult();
    }

    public boolean repeatSuccess() {
        for (int i = 0; i < bridge.size(); i++) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String move = inputView.readMoving();

            moveingControl(i,move);

            if(BridgeGame.getIsPlayerFailed()){
                return false;
            }
        }
        return true;
    }

    public void moveingControl(int moveingIndex, String move){
        if (bridgeGame.checkAnswer(bridge.get(moveingIndex), move)) {
            bridgeGame.move(move);
        }
        if (!bridgeGame.checkAnswer(bridge.get(moveingIndex), move)) {
            bridgeGame.moveFailed(move);
            bridgeGame.switchResult();
        }
        outputView.printMap();
    }

    public void makeBridge(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    public void askRetryGame(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        boolean retry = bridgeGame.retry(inputView.readGameCommand());

        if(retry){
            bridgeGame.switchResult();
            startGame();
            return;
        }
        outputView.printMap();
    }
}
