package bridge;

import bridge.model.BridgeMap;
import bridge.model.RandomBridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String UP = "U";
    private static final String QUIT = "Q";
    private static final BridgeGame INSTANCE = new BridgeGame();

    private RandomBridge randomBridge;
    private BridgeMap bridgeMap;
    private int tryCount;

    private boolean isSuccess;

    private BridgeGame() {
    }

    public static BridgeGame getInstance() {
        return INSTANCE;
    }

    public void init(int size) {
        this.randomBridge = new RandomBridge(size);
        this.bridgeMap = new BridgeMap();
        this.tryCount = 1;
        this.isSuccess = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving, int bridgeIndex) {
        boolean isUpSide = moving.equals(UP);
        boolean isRight = this.randomBridge.isRight(moving, bridgeIndex);

        this.bridgeMap.add(isUpSide, isRight);

        if (isRight && this.randomBridge.isEndIndex(bridgeIndex)) {
            this.isSuccess = true;
        }

        return isRight;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals(QUIT)) {
            return false;
        }

        this.bridgeMap = new BridgeMap();
        this.tryCount += 1;
        this.isSuccess = false;
        return true;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String bridgeMapToString() {
        return bridgeMap.toString();
    }

    public String gameResultToString() {
        return "최종 게임 결과\n" + bridgeMap.toString() +
                "\n" +
                successOrNotToString() +
                "총 시도한 횟수: " +
                tryCount;
    }

    private String successOrNotToString() {
        if (isSuccess) {
            return "\n게임 성공 여부: 성공\n";
        }

        return "\n게임 성공 여부: 실패\n";
    }
}
