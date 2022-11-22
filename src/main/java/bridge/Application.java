package bridge;

public class Application {
    static final InputView inputView = new InputView();
    static final OutputView outputView = new OutputView();
    static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));

        while (bridgeGame.move(inputView.readMoving())) {
            outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserMove());
            if (bridgeGame.isClear()) {
                break;
            }
        }
        System.out.println("최종 게임 결과");
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserMove());
    }
}
