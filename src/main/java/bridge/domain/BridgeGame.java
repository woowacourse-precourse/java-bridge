package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.RealTimeBridge;
import bridge.utils.InputHandler;
import bridge.view.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final static String SUCCESS = "성공";
    private final static String FAIL = "실패";

    RealTimeBridge realTimeBridge = new RealTimeBridge();
    OutputView outputView = new OutputView();
    InputHandler inputHandler = new InputHandler();

    private int count = 0;
    boolean isAnswer = true;
    public String[][] realTimeMap = realTimeBridge.getMap();

    public BridgeGame() {

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String bridgeText, String userMove) {
        if (!bridgeText.equals(userMove)) {
            return " X ";
        }
        return " O ";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    private boolean retry() {
        if(!isAnswer){
            String gameCommand = inputHandler.getGameCommand();
            return gameCommand.equals("R");
        }
        return false;
    }

    private void initializeVariables() {
        isAnswer = true;
        count++;
        realTimeBridge.initialize();
    }

    public void start(int size, List<String> bridge) {
        do {
            play(size, bridge);
        } while(retry());
        outputView.printResult(isAnswer, count, realTimeMap);
    }

    private void play(int size, List<String> bridge) {
        initializeVariables();
        for (int i = 0; i < size; i++) {
            if (compareInputActual(bridge, i)) {
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
        if (moveResult.equals(" X ")) {
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

    public String isSuccess(boolean flag) {
        if (flag) {
            return SUCCESS;
        }
        return FAIL;
    }
}
