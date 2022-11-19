package bridge.domain;

import bridge.utils.InputHandler;
import bridge.utils.enums.GameCommand;
import bridge.utils.enums.MovingResult;
import bridge.view.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final RealTimeBridge realTimeBridge = new RealTimeBridge();
    private final OutputView outputView = new OutputView();
    private final InputHandler inputHandler = new InputHandler();
    private final String[][] realTimeMap = realTimeBridge.getMap();

    private int count = 0;
    private boolean isAnswer = true;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private String move(String bridgeText, String userMove) {
        if (!bridgeText.equals(userMove)) {
            return MovingResult.WRONG.getValue();
        }
        return MovingResult.CORRECT.getValue();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    private boolean retry() {
        if (!isAnswer) {
            String gameCommand = inputHandler.getGameCommand();
            return gameCommand.equals(GameCommand.RETRY.getValue());
        }
        return false;
    }

    private void initializeVariables() {
        isAnswer = true;
        count++;
        realTimeBridge.initialize();
    }

    public void start(int size, List<String> bridge) {
        outputView.printStartMessage();
        do {
            play(size, bridge);
        } while (retry());
        outputView.printResult(isAnswer, count, realTimeMap);
    }

    private void play(int size, List<String> bridge) {
        initializeVariables();
        for (int block = 0; block < size; block++) {
            if (compareInputActual(bridge, block)) {
                break;
            }
        }
    }

    private boolean compareInputActual(List<String> bridge, int index) {
        String userMove = inputHandler.getMoving();
        String moveResult = move(userMove, bridge.get(index));
        return isWrong(realTimeMap, userMove, moveResult);
    }

    private boolean isWrong(String[][] realTimeMap, String userMove, String moveResult) {
        if (moveResult.equals(MovingResult.WRONG.getValue())) {
            printRealTimeMap(realTimeMap, userMove, moveResult);
            isAnswer = false;
            return true;
        }
        printRealTimeMap(realTimeMap, userMove, moveResult);
        return false;
    }

    private void printRealTimeMap(String[][] realTimeMap, String userMove, String moveResult) {
        realTimeBridge.makeRealTimeBridge(userMove, moveResult);
        outputView.printMap(realTimeMap);
    }
}
