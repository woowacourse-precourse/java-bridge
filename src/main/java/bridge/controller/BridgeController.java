package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private InputView inputView;
    private OutputView outputView;
    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        BridgeGame bridgeGame = constructBridge(); // 게임 끝까지 사용
        do {
            movePlayer(bridgeGame); // inputview를 입력받아 이동
            printResult(bridgeGame);
             // 입력한 결과를 형식에 맞게 출력
        }while (!bridgeGame.gameOver());
        // 재시도 여부 bridgeGame.retry(); inputView.readGameCommand()
        // 게임 종료 여부를 판단하고 최종 게임결과 출력 outVIew.printResult()
    }

    private BridgeGame constructBridge() {
        int bridgeSize = inputView.readBridgeSize();
        return new BridgeGame(bridgeSize);
    }

    private void movePlayer(BridgeGame bridgeGame) {
        String playerMoving = inputView.readMoving();
        bridgeGame.move(playerMoving);
    }

    private void printResult(BridgeGame bridgeGame){
        outputView.printMap(bridgeGame);
    }
}
