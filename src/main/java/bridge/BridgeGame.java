package bridge;

import bridge.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputController inputController;
    private final OutputController outputController;
    private List<String> board;
    private Map<String, Integer> resultBoard;
    private int count;

    public BridgeGame(BridgeNumberGenerator numberGenerator) {
        this.inputController = new InputController(
                new InputView(),
                new OutputView(),
                new BridgeMaker(numberGenerator)
        );
        this.outputController = new OutputController(new OutputView());
        count = 1;
        initialize();
    }

    private void initialize() {
        board = new ArrayList<>();
        resultBoard = new HashMap<>();
        resultBoard.put(Constant.SUCCESS_OR_FAIL, null);
        resultBoard.put(Constant.NUMBER_OF_ATTEMPTS, count);
    }

    public void start() throws IllegalArgumentException {
        List<String> bridge = inputController.getBridge(inputController.getBridgeSize());
        play(bridge);
    }

    public void play(List<String> bridge) throws IllegalArgumentException {
        int result;
        while (isContinue(board, bridge, board.size() - 1)) {
            move();
            outputController.getChoiceResult(board, bridge);
        }
        result = isSuccess(board, bridge);
        resultBoard.put(Constant.SUCCESS_OR_FAIL, result);
        outputController.getFinalResult(board, bridge, resultBoard);
    }

    private boolean isContinue(List<String> board, List<String> bridge, int index) throws IllegalArgumentException {
        if (index < 0) {
            return true;
        }
        if (!board.get(index)
                .equals(bridge.get(index))) {
            return retry();
        }
        return board.size() != bridge.size();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() throws IllegalArgumentException {
        String direction = inputController.getMovingDirection();
        board.add(direction);
    }

    private int isSuccess(List<String> board, List<String> bridge) {
        int boardIndex = board.size() - 1;
        int bridgeIndex = bridge.size() - 1;

        if ((boardIndex == bridgeIndex) && board.get(boardIndex)
                .equals(bridge.get(bridgeIndex))) {
            return 1;  //성공
        }
        return 0;  //실패
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() throws IllegalArgumentException {
        String retryOrQuit = inputController.getGameCommand();
        if (retryOrQuit.equals(Constant.RETRY)) {
            count++;
            initialize();
            return true;
        }
        return false;
    }
}
