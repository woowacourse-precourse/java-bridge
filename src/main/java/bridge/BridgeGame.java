package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String RETRY = "R";
    private static final boolean SUCCESS = true;
    private static final boolean FAIL = false;
    private static final int FIRST = 1;

    private Bridge bridge;
    private Player player;
    private int crossCount = 0;
    private int bridgeSize;
    private int tryNumber = 1;

    public BridgeGame() {
    }

    public void gameStart() {
        if(tryNumber==FIRST) {
            System.out.println(GAME_START_MESSAGE + "\n");
            player = new Player();
        }
        makeBridge();
        while(crossCount < bridgeSize && move()) {
            crossCount++;
        }
        gameStop();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        if(bridge.isToCross(player.move(), crossCount)) {
            bridge.printBridge();
            return true;
        }
        bridge.printBridge();
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        crossCount = 0;
        if(player.retry().equals(RETRY)) {
            tryNumber++;
            gameStart();
            return;
        }
        bridge.printResult(FAIL, tryNumber);
    }

    private void gameStop() {
        if(crossCount == bridgeSize) {
            bridge.printResult(SUCCESS, tryNumber);
            return;
        }
        retry();
    }

    private void makeBridge() {
        if(tryNumber == FIRST){
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            bridgeSize = bridgeMaker.inputBridgeSize();
            bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
            return;
        }
        bridge = new Bridge(bridge.getList());
    }
}
