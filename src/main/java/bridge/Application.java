package bridge;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);

        boolean roundResult = false;
        while (!(bridgeGame.doesCrossedBridge())) {
            String userPath = inputView.readMoving(); //InputView 클래스 사용
            roundResult = bridgeGame.move(userPath); //BridgeGame 클래스 사용
            outputView.printMap(bridgeGame.getPassedPaths(), roundResult); //OutputView 클래스 사용
            if (roundResult == false) {
                String retryOrEnd = inputView.readGameCommand();
                if (retryOrEnd.equals("R")) {
                    bridgeGame.retry();
                    continue;
                }

                if (retryOrEnd.equals("Q")) {
                    break;
                }
            }
        }

        System.out.println();

        outputView.printResult(bridgeGame, roundResult);

    }
}
