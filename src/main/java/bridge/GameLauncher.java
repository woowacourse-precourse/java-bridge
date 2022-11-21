package bridge;

import java.util.List;

public class GameLauncher {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;

    public GameLauncher(InputView inputView, OutputView outputView, BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
    }

    public void launch() {
        Bridge bridge = init();
        do {
            bridge.reGame();
            game(bridge);
        } while (!bridgeGame.isClearGame(bridge) && bridgeGame.retry(inputGameCommand()));
        outputView.printResult(bridge);
    }

    public void game(Bridge bridge) {
        do {
            String direction = inputMoving();
            bridgeGame.move(bridge, direction);
            outputView.printMap(bridge);
        } while (bridgeGame.isSurvive(bridge) && !bridgeGame.isClearGame(bridge));
    }

    public Bridge init() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        int bridgeSize = inputBridgeSize();
        List<String> bridgeShape = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridgeShape);
    }

    public int inputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] ".concat(ex.getMessage()));
            return inputBridgeSize();
        }
    }

    public String inputMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] ".concat(ex.getMessage()));
            return inputMoving();
        }
    }

    public String inputGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] ".concat(ex.getMessage()));
            return inputGameCommand();
        }
    }
}
