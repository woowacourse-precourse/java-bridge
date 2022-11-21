package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int bridgeSize;
    private int gameIndex;
    private int tryCount = 1;
    private boolean gameResult;
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private final Map<Boolean, String> MOVE_OX = Map.of(
        true, "O",
        false, "X"
    );
    private final Map<String, String> REVERSE_MOVE = Map.of(
        "U", "D",
        "D", "U"
    );

    public void initGame() {
        int bridgeSize = inputView.readBridgeSize();
        setBridgeSize(bridgeSize);
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeMaker.makeBridge(bridgeSize);
        setGameIndex(0);
        setGameResult(true);
    }

    public void startGame() {
        initGame();
        boolean flag = true;
        while (flag && getGameIndex() != getBridgeSize()) {
            flag = move(getGameIndex());
        }
        endGame();
    }

    public void endGame() {
        outputView.printResult(bridgeMaker.getPresentBridge(), isGameResult(), getTryCount());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int bridgeIndex) {
        String moveCommand = inputView.readMoving();
        if (judgeMove(moveCommand, bridgeIndex)) {
            recordBridge(moveCommand);
            return true;
        }
        setGameResult(false);
        setGameIndex(getGameIndex() + 1);
        return judgeContinue();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        initGame();
        setTryCount(getTryCount() + 1);
    }

    public void recordBridge(String moveCommand) {
        HashMap<String, List<String>> presentBridge = bridgeMaker.getPresentBridge();
        if (presentBridge.containsKey(moveCommand)) {
            presentBridge.get(moveCommand).add(MOVE_OX.get(moveCommand));
        } else {
            presentBridge.put(moveCommand, List.of(MOVE_OX.get(moveCommand)));
        }
        presentBridge.get(REVERSE_MOVE.get(moveCommand)).add(" ");
    }

    public boolean judgeMove(String moveCommand, int bridgeIndex) {
        List<String> bridge = bridgeMaker.getBridge();
        if (bridge.get(bridgeIndex).equals(moveCommand)) {
            return true;
        }
        return false;
    }

    public boolean judgeContinue() {
        String gameCommand = inputView.readGameCommand();

        if (gameCommand.equals("R")) {
            retry();
            return true;
        }
        return false;
    }

    public int getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(int gameIndex) {
        this.gameIndex = gameIndex;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public boolean isGameResult() {
        return gameResult;
    }

    public void setGameResult(boolean gameResult) {
        this.gameResult = gameResult;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    public void setBridgeSize(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }
}
