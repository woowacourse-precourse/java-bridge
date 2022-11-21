package bridge;

public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private final BridgeMaker bridgeMaker;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(this.bridgeRandomNumberGenerator);
    }

    public void play() {
        System.out.println("게임 시작");
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        move();
        retry();
    }

    public void move() {
        System.out.println("이동 입력");
        String moving = inputView.readMoving();
    }

    public void retry() {
        System.out.println("게임 재시작 유무");
        String answer = inputView.readGameCommand();
    }
}
