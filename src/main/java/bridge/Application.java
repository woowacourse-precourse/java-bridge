package bridge;

import java.util.List;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        try {
            BridgeGame bridgeGame = createBridgeGame();
            playGame(bridgeGame);
            outputView.printResult(bridgeGame.getAttempts(), bridgeGame.getUser(), bridgeGame.getBridge());
        } catch (IllegalStateException illegalStateException) {
            System.out.println(illegalStateException.getMessage());
        }
    }

    private static BridgeGame createBridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        return new BridgeGame(bridge);
    }

    public static void playGame(BridgeGame bridgeGame) {
        while (!bridgeGame.getUser().equals(bridgeGame.getBridge())) {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getUser(), bridgeGame.getBridge());
            if (!bridgeGame.isCorrect() && !bridgeGame.retry(inputView.readGameCommand())) {
                break;
            }
        }
    }
}
