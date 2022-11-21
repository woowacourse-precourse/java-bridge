package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int MINBRIDGELEN = 3;
    private final int MAXBRIDGELEN = 20;
    InputView inputview = new InputView();
    OutputView outputView = new OutputView();
    List<String> visited = new ArrayList<>();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    Validate validate = new Validate();
    Bridge bridge;
    private int tryNum = 1;
    public void init() {
        String input = inputview.readBridgeSize();
        validate.validateNumberRange(input, MINBRIDGELEN, MAXBRIDGELEN);
        int bridgeLen = Integer.parseInt(input);
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeLen);
        bridge = new Bridge(answerBridge);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        String direction = inputview.readMoving();
        validate.validateIsUpOrDown(direction);
        visited.add(direction);
        printUpBridge();
        printDownBridge();
        int index = visited.size() - 1;
        return bridge.isRightDirection(index, direction);
    }
    private void printUpBridge() {
        List<String> upBridge = new ArrayList<>();
        for(int i = 0; i < visited.size(); i++) {
            boolean rightDirection = bridge.isRightDirection(i, visited.get(i));
            String result = getResult(i, "U", rightDirection);
            upBridge.add(result);
        }
        outputView.printMap(upBridge);
    }
    private void printDownBridge() {
        List<String> downBridge = new ArrayList<>();
        for(int i = 0; i < visited.size(); i++) {
            boolean rightDirection = bridge.isRightDirection(i, visited.get(i));
            String result = getResult(i, "D", rightDirection);
            downBridge.add(result);
        }
        outputView.printMap(downBridge);
    }
    private String getResult(int i, String direction, boolean rightDirection) {
        String result = "X";
        if(rightDirection) {
            result = "O";
        }
        if(!visited.get(i).equals(direction)) {
            result = " ";
        }
        return result;
    }
    public boolean isGameCompleted() {
        if(bridge.isCrossedBridge(visited)) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String select = inputview.readGameCommand();
        if(select.equals("R")) {
            reStartInit();
            return true;
        }
        return false;
    }
    public void reStartInit() {
        visited = new ArrayList<>();
        tryNum += 1;
    }

    public void printGameResult() {
        outputView.printEnding();
        printUpBridge();
        printDownBridge();
        boolean isSuccess = bridge.isCrossedBridge(visited);
        String result = "실패";
        if(isSuccess) {
            result = "성공";
        }
        outputView.printResult(result, tryNum);
    }
}
