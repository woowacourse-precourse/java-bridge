package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
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
            if (bridgeMap.get(upBridge.size()).equals(userMoving)) {
                upBridge.add("O");
                downBridge.add(" ");
                return true;
            }
        }
        if (userMoving.equals("D")) {
            if (bridgeMap.get(downBridge.size()).equals(userMoving)) {
                upBridge.add(" ");
                downBridge.add("O");
                return true;
            }
        }
        return false;
    }

    public void failMove(List<String> bridgeMap, String userMoving, int i) {
        if (userMoving.equals("U")) {
            if (!bridgeMap.get(i).equals(userMoving)) {
                upBridge.add("X");
                downBridge.add(" ");
                failResult(upBridge, downBridge, bridgeMap);
            }
        }
        if (userMoving.equals("D")) {
            if (!bridgeMap.get(i).equals(userMoving)) {
                upBridge.add(" ");
                downBridge.add("X");
                failResult(upBridge, downBridge, bridgeMap);
            }
        }
    }


    public void failResult(List<String> upperBridge, List<String> lowerBridge, List<String> answer) {
        outputView.printMap(upperBridge);
        outputView.printMap(lowerBridge);
        retry(upperBridge, lowerBridge, answer);
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> up, List<String> down, List<String> answer) {
        InputView inputView = new InputView();
        Message.requestContinueMessage();
        String userCommand = inputView.readGameCommand();
        if (userCommand.equals("R")) {
            gameTryCount += 1;
            System.out.println("R");
            test(answer);
            return ;
        }
        resultMessage(up, down);
    }

    public void resultMessage(List<String> up, List<String> down) {
        Message.gameResultMesaage();
        outputView.printMap(up);
        outputView.printMap(down);

        Message.result();

        if (up.contains("X") || down.contains("X")) {
            Message.fail();
        }

        Message.tryCount(gameTryCount);
    }
    public void result(int gameTryCount) {
        Message.gameResultMesaage();
        outputView.printMap(upBridge);
        outputView.printMap(downBridge);
        Message.result();
        Message.success();
        Message.tryCount(gameTryCount);
    }

    public void gamePlay() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        Message.startMessage();
        Message.requestBridgeSizeMessage();
        int size = inputView.readBridgeSize();
        System.out.println("size : " + size);
        List<String> answer = bridgeMaker.makeBridge(size); // 정답
        test(answer);
    }
    public void test (List<String> answer) {
        Message.requestMovingMessage();
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();

        System.out.println("answer = " + answer);

        for (int i = 0; i < answer.size(); i++) {
            String userMovingValue = inputView.readMoving();
            if(!move(answer,userMovingValue)) { // 정답을 맞추면 현재 다리에 O를 추가한다
                failMove(answer, userMovingValue, i);
                return ;
            }
            outputView.printMap(upBridge); // 추가된 다리만큼만 출력한다
            outputView.printMap(downBridge);
        }
        result(gameTryCount);
    }
}
