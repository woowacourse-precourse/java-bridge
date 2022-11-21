package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    final private InputView inputView;
    final private OutputView outputView;
    final private BridgeMaker bridgeMaker;

    private List<String> bridge;
    private List<String> playerBridge;

    private int tryCount;

    /**
     * BridgeGame 필드 초기화 생성자
     */
    public BridgeGame() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new ArrayList<>();
        playerBridge = new ArrayList<>();
        tryCount = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        outputView.printInputMove();
        playerBridge.add(inputView.readMoving());
        outputView.printMap(playerBridge, bridge);
    }

    /**
     * 다리 건너기 게임이 끝나는지 체크하는 메서드
     *
     * @return 0 - 게임이 끝나지 않음
     * 1 - 게임이 성공적으로 끝남
     * 2- 게임이 실패로 끝남
     */
    public int checkGameOver() {
        if (playerBridge.size() == bridge.size()) {
            if (playerBridge.get(playerBridge.size() - 1).equals(bridge.get(playerBridge.size() - 1))) return 1;
            return 2;
        }
        if (playerBridge.get(playerBridge.size() - 1).equals(bridge.get(playerBridge.size() - 1))) return 0;
        return 2;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return true - 재시작
     * false-  게임 종료
     */
    public boolean retry() {
        outputView.printInputRetry();
        String input = inputView.readGameCommand();
        if (input.equals("R")) {
            playerBridge.clear();
            tryCount++;
            return true;
        }
        if (input.equals("Q")) return false;
        System.out.println("[ERROR] 입력 값은 \"R\" 또는 \"Q\"여야 합니다.");
        throw new IllegalArgumentException();
    }

    /**
     * 다리를 생성하는 메서드
     */
    public void buildBridge() {
        outputView.printInputBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }


    /**
     * 게임 오버 처리 메서드
     *
     * @param gameOverResult 1: 게임이 성공적으로 끝남 <p>2: 게임이 실패로 끝남
     */
    public void gameOver(int gameOverResult) {
        outputView.printResult(playerBridge, bridge, tryCount, gameOverResult);
    }

    /**
     * 전체 게임 동작 관리를 위해 사용하는 메서드
     */
    public void start() {
        outputView.printStartGame();
        int gameOverResult = -1;
        buildBridge();
        while (true) {
            move();
            gameOverResult = checkGameOver();
            if (gameOverResult == 0) continue;
            if (!retry()) break;
        }
        gameOver(gameOverResult);
    }
}
