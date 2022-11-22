package bridge;

import bridge.model.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
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

    private final Map<Boolean, String> MOVE_OX = Map.of(
        true, "O",
        false, "X"
    );
    private final Map<String, String> REVERSE_MOVE = Map.of(
        "U", "D",
        "D", "U"
    );

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void initGame() {
        int bridgeSize = inputView.readBridgeSize();
        setBridgeSize(bridgeSize);
//        bridgeMaker.makeBridges(bridgeSize);
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
//        outputView.printResult(bridgeMaker.getPresentBridge(), isGameResult(), getTryCount());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int bridgeIndex) {
        String moveCommand = inputView.readMoving();
        recordBridge(moveCommand, judgeMove(moveCommand, bridgeIndex));
//        outputView.printMap(bridgeMaker.getPresentBridge());
        if (judgeMove(moveCommand, bridgeIndex)) {
            setGameIndex(getGameIndex() + 1);
            return true;
        }
        setGameResult(false);
        return judgeContinue();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
//        bridgeMaker.initPresentBridge();
        setGameIndex(0);
        setGameResult(true);
        setTryCount(getTryCount() + 1);
    }

    public void recordBridge(String moveCommand, boolean isSuccess) {
//        HashMap<String, List<String>> presentBridge = bridgeMaker.getPresentBridge();
//        List<String> moveLine = presentBridge.get(moveCommand);
//        moveLine.add(MOVE_OX.get(isSuccess));
//        presentBridge.replace(moveCommand, moveLine);
//        List<String> reverseLine = presentBridge.get(REVERSE_MOVE.get(moveCommand));
//        reverseLine.add(" ");
//        presentBridge.replace(REVERSE_MOVE.get(moveCommand), reverseLine);
//        bridgeMaker.setPresentBridge(presentBridge);
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
