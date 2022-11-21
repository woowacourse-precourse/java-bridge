package bridge;

import bridge.bridgeGame.BridgeGame;
import bridge.bridgeGame.BridgeGameResultDto;
import bridge.bridgeMaker.BridgeMaker;
import bridge.enums.GameStatus;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        try {
            // 다리 길이를 입력받고 다리를 생성
            List<String> answerBridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
            BridgeGame bridgeGame = new BridgeGame(answerBridge);

            // 게임 시작
            while (true) {
                // TODO: while문 안 기능 분배 리팩토링
                BridgeGameResultDto moveResult = bridgeGame.move(inputView.readMoving());
                outputView.printMap(moveResult.getGradingBoard());
                if (moveResult.getGameStatus().equals(GameStatus.FAIL)) {
                    String s = inputView.readGameCommand();
                    if (s.equals("Q")) {
                        outputView.printResult(moveResult.getGradingBoard(), moveResult.getGameStatus(), moveResult.getTotalAttemptNum());
                        break;
                    }
                    if (s.equals("R")) {
                        bridgeGame.retry();
                    }
                }
                if (moveResult.getGameStatus().equals(GameStatus.SUCCESS)) {
                    outputView.printResult(moveResult.getGradingBoard(), moveResult.getGameStatus(), moveResult.getTotalAttemptNum());
                    break;
                }
            }
        } catch (IllegalArgumentException iae) {
            return;
        }
    }




}
