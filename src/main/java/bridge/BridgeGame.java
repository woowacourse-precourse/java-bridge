package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame { // private로 선언 후 getter, setter 생성
    Controller controller = new Controller();
    List<String> upBridge;
    List<String> downBridge;
    int gameTryCount = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public boolean move(List<String> bridgeMap, String userMoving) {
        if (userMoving.equals("U")) {
            return addUpAnswer(bridgeMap, userMoving);
        }
        if (userMoving.equals("D")) {
            return addDownAnswer(bridgeMap, userMoving);
        }
        return false;
    }

    public boolean addUpAnswer(List<String> bridgeMap, String userMoving) {
        if (bridgeMap.get(upBridge.size()).equals(userMoving)) {
            upBridge.add("O");
            downBridge.add(" ");
            return true;
        }
        return false;
    }

    public boolean addDownAnswer(List<String> bridgeMap, String userMoving) {
        if (bridgeMap.get(downBridge.size()).equals(userMoving)) {
            upBridge.add(" ");
            downBridge.add("O");
            return true;
        }
        return false;
    }

    public void failMove(List<String> bridgeMap, String userMoving, int i) {
        if (userMoving.equals("U")) {
            if (failUpMoveAdd(bridgeMap, userMoving, i)) {
                failResult(upBridge, downBridge, bridgeMap);
            }
        }
        if (userMoving.equals("D")) {
            if (failDownMoveAdd(bridgeMap, userMoving, i)) {
                failResult(upBridge, downBridge, bridgeMap);
            }
        }
    }

    public boolean failUpMoveAdd(List<String> bridgeMap, String userMoving, int i) {
        if (!bridgeMap.get(i).equals(userMoving)) {
            upBridge.add("X");
            downBridge.add(" ");
            return true;
        }
        return false;
    }

    public boolean failDownMoveAdd(List<String> bridgeMap, String userMoving, int i) {
        if (!bridgeMap.get(i).equals(userMoving)) {
            upBridge.add(" ");
            downBridge.add("X");
            return true;
        }
        return false;
    }


    public void failResult(List<String> upperBridge, List<String> lowerBridge, List<String> answer) {
        controller.outputViewResult(upperBridge, lowerBridge);
        retry(upperBridge, lowerBridge, answer);
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> up, List<String> down, List<String> answer) {
        Message.requestContinueMessage();
        String userCommand = controller.inputViewCommand();
        if (userCommand.equals("R")) {
            gameTryCount += 1;
            resetBridge();
            bridgeLogic(answer);
            return ;
        }
        resultMessage(up, down);
    }

    public void resetBridge() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }
    public void resultMessage(List<String> up, List<String> down) {
        Message.gameResultMesaage();
        controller.outputViewResult(up, down);

        Message.result();

        if (up.contains("X") || down.contains("X")) {
            Message.fail();
        }

        Message.tryCount(gameTryCount);
    }
    public void result(int gameTryCount) {
        Message.gameResultMesaage();
        controller.outputViewResult(upBridge, downBridge);
        Message.result();
        Message.success();
        Message.tryCount(gameTryCount);
    }

    public void gameSetting() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        Message.startMessage();
        Message.requestBridgeSizeMessage();
        int size = controller.inputViewSize();
        List<String> answer = bridgeMaker.makeBridge(size); // 정답
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
        bridgeLogic(answer);
    }
    public void bridgeLogic(List<String> answer) {
        for (int i = 0; i < answer.size(); i++) {
            Message.requestMovingMessage();
            String userMovingValue = controller.inputViewMoving();
            if(!move(answer,userMovingValue)) {
                failMove(answer, userMovingValue, i);
                return ;
            }
            controller.outputViewResult(upBridge, downBridge);
        }
        result(gameTryCount);
    }
}
