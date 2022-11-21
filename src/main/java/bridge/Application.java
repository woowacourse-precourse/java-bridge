package bridge;

import bridge.Setting.OutputViewPrintEnum;

public class Application {

    public static void main(String[] args) {
        System.out.println(OutputViewPrintEnum.GAME_START.getMessage());
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame(new BridgeRandomNumberGenerator(), inputView.readBridgeSize());
        while (bridgeGame.keepMove()){
            bridgeGame.move();
            bridgeGame.retry();
        }
        OutputView outputView = new OutputView();
        outputView.printResult(bridgeGame.getResultLines());
        // TODO: 프로그램 구현
    }
}
