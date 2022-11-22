package bridge;

public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private final BridgeMaker bridgeMaker;
    private final GameEndChecker gameEndChecker;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(this.bridgeRandomNumberGenerator);
        this.gameEndChecker = new GameEndChecker();
    }

    public void play() {
        System.out.println("게임 시작");
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        while (!gameEndChecker.getEnd()) {
            crossBridge(bridge);
        }
    }

    private void crossBridge(Bridge bridge) {
    }

    public String move() {
        System.out.println("이동 입력");
        String moving = inputView.readMoving();
        return moving;
    }

    public void retry() {
        System.out.println("게임 재시작 유무");
        String answer = inputView.readGameCommand();
        Quit(answer);
    }
    private void Quit(String answer) {
        // TODO: Enum으로 리팩토링
        if (answer.equals("Q")) {
            gameEndChecker.setEnd(true);
        }
    }
}
