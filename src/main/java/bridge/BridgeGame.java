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
        crossBridge(bridge);
        retry();
    }

    private void crossBridge(Bridge bridge) {
        int index = 0;
        while (true) {
            String moving = move();
            if (!bridge.canMove(index, moving)) {
                outputView.printMap();
                retry();
                break;
            }
        }
    }

    public String move() {
        System.out.println("이동 입력");
        String moving = inputView.readMoving();
        return moving;
    }

    public String retry() {
        System.out.println("게임 재시작 유무");
        String answer = inputView.readGameCommand();
        return answer;
    }
}
