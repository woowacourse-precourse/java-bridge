package bridge;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private final Bridge bridge;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new Bridge();
    }

    public void runGame() {
        beforeStartGame();
        startGame(1);
    }

    public void beforeStartGame() {
        outputView.printLine("다리 건너기 게임을 시작합니다.\n");
        outputView.printLine("다리의 길이를 입력해주세요");
        int size = inputView.readBridgeSize();
        bridge.setElementsOfBridge(bridgeMaker.makeBridge(size));
        System.out.println();
    }

    public void duringGame(String element) {
        outputView.printLine("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String s = inputView.readMoving();
        bridgeGame.move(element, s);
        outputView.printMap(bridgeGame.getLines());
        System.out.println();
    }

    public void startGame(int count) {
        for (String element : bridge.getElementsOfBridge()) {
            duringGame(element);
            if (bridgeGame.isFailed() && checkRetry(count)) {
                startGame(count + 1);
                return;
            }
        }
        outputView.printResult(bridgeGame.getLines(), "성공", count);
    }

    public boolean checkRetry(int count) {
        outputView.printLine("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        if (bridgeGame.retry(inputView.readGameCommand())) {
            return true;
        } else {
            outputView.printResult(bridgeGame.getLines(), "실패", count);
            return false;
        }
    }
}
