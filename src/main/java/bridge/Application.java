package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        System.out.println("다리 건너기 게임을 시작합니다.\n");
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        while (!bridgeGame.endGame()) {
            if (bridgeGame.move(inputView.readMoving())) {
                System.out.println(outputView.printMap(bridgeGame.currentBridge()));
                continue;
            }
            System.out.println(outputView.printMap(bridgeGame.currentBridge()));
            if (!bridgeGame.retry(inputView.readGameCommand())) {
                break;
            }
        }
        System.out.println(outputView.printResult(bridgeGame.currentBridge(), bridgeGame.getNumberOfTry()));
    }

}
