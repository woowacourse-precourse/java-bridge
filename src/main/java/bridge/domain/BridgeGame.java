package bridge.domain;

public class BridgeGame {
    private static final String SUCCESS_MESSAGE = "\n게임 성공 여부: 성공\n";
    private static final String FAIL_MESSAGE = "\n게임 성공 여부: 실패\n";
    private static final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: %d";
    private static final int ZERO_COUNT = 0;
    private int tryCount;
    private final Bridge bridge;
    private CurrentBridgeMap currentBridgeMap;
    private PlayerMovement playerMovement;

    public BridgeGame(Bridge bridge) {
        tryCount = 1;
        this.bridge = bridge;
        currentBridgeMap = new CurrentBridgeMap();
        playerMovement = new PlayerMovement();
    }

    public String move(String inputValue) {
        playerMovement.addMovement(inputValue);
        return currentBridgeMap.getCurrentBridgeMap(inputValue, isAllEqualSoFar());
    }

    public void retry() {
        tryCount++;
        currentBridgeMap = new CurrentBridgeMap();
        playerMovement = new PlayerMovement();
    }

    private boolean isAllEqualSoFar() {
        return bridge.isAllEqualSoFar(playerMovement.getMovement());
    }

    public boolean isFinish() {
        if (isEndBridge()) {
            return true;
        }
        if (playerMovement.getMovementCount() == ZERO_COUNT) {
            return false;
        }

        return !isAllEqualSoFar();
    }

    private boolean isEndBridge() {
        return bridge.getBridgeSize() == playerMovement.getMovementCount();
    }

    public boolean isSuccess() {
        return bridge.isEqual(playerMovement.getMovement());
    }

    public String getResultGame() {
        return getResultBridgeMap() + getResultSuccessOrFail() + getResultTry();
    }

    private String getResultBridgeMap() {
        return currentBridgeMap.getBridgeMap();
    }

    private String getResultSuccessOrFail() {
        if (isEndBridge()) {
            return SUCCESS_MESSAGE;
        }

        return FAIL_MESSAGE;
    }

    private String getResultTry() {
        return String.format(TOTAL_TRY_COUNT_MESSAGE, tryCount);
    }
}
