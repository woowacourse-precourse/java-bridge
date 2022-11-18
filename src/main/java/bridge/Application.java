package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // 다리 길이를 입력받고 다리를 생성
        List<String> answerBridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(answerBridge);

        // 게임 시작
        try {
            while (true) {
                // TODO: while문 안 기능 분배 리팩토링
                BridgeGameResultDto moveResult = bridgeGame.move(inputView.readMoving());
                outputView.printMap(moveResult.getGradingBoard());
                if (moveResult.getGameStatus().equals(GameStatus.FAIL)) {
                    String s = inputView.readGameCommand();
                    if (s.equals("Q")) {
                        outputView.printResult(moveResult.getGradingBoard(),moveResult.getGameStatus());
                        break;
                    }
                    if (s.equals("R")) {
                        bridgeGame.retry();
                    }
                }
                if (moveResult.getGameStatus().equals(GameStatus.SUCCESS)) {
                    outputView.printResult(moveResult.getGradingBoard(),moveResult.getGameStatus());
                    break;
                }
            }
        } catch (IllegalArgumentException iae) {
            return;
        }

    }
}
