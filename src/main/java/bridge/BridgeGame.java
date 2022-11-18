package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    // 외부에 새 currentBridge를 선언하고, 하나씩 추가하는 방식은 어떨까ㅏㅏ..
    // 정답과 유저의 값이 일치하면 현재 다리에 O를 추가하고,
    // 이외의 경우에는 공백을 추가한다.
    // 정답과 유저의 값이 일치하지 않을 경우 -> 예외 발생 후 다시 재입력 받도록 한다.
    public void move(List<String> bridgeMap, List<String> upperBridge, List<String> lowerBridge, String userMoving) {
        if (userMoving.equals("U")) {
            if (bridgeMap.get(upperBridge.size()).equals(userMoving)) {
                upperBridge.add("O");
                lowerBridge.add(" ");
            }
        }
        if (userMoving.equals("D")) {
            if (bridgeMap.get(lowerBridge.size()).equals(userMoving)) {
                upperBridge.add(" ");
                lowerBridge.add("O");
            }
        }
    }

    public void failMove(List<String> bridgeMap, List<String> upperBridge, List<String> lowerBridge, String userMoving, int i) {
        if (userMoving.equals("U")) {
            if (!bridgeMap.get(i).equals(userMoving)) {
                upperBridge.add("X");
                lowerBridge.add(" ");
                failResult(upperBridge, lowerBridge);
            }
        }
        if (userMoving.equals("D")) {
            if (!bridgeMap.get(i).equals(userMoving)) {
                upperBridge.add(" ");
                lowerBridge.add("X");
                failResult(upperBridge, lowerBridge);
            }
        }
    }


    public void failResult(List<String> upperBridge, List<String> lowerBridge) {
        System.out.println("upperBridge = " + upperBridge);
        System.out.println("lowerBridge = " + lowerBridge);
        retry();
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String userCommand = Console.readLine();
        if (userCommand.equals("R")) {
            System.out.println("R");
        }
        if (userCommand.equals("Q")) {
            System.out.println("Q");
        }
    }

    public void gamePlay() {
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        OutputView outputView = new OutputView();

        Message.startMessage();
        Message.requestBridgeSizeMessage();
        int size = inputView.readBridgeSize();

        Message.requestMovingMessage();

        List<String> upperCurrentBridge = new ArrayList<>(); // 위쪽 다리
        List<String> lowerCurrentBridge = new ArrayList<>(); // 아래쪽 다리
        List<String> answer = bridgeMaker.makeBridge(size); // 정답
        System.out.println("answer = " + answer);

        for (int i = 0; i < size; i++) {
            String userMovingValue = inputView.readMoving();
            move(answer, upperCurrentBridge, lowerCurrentBridge, userMovingValue); // 정답을 맞추면 현재 다리에 O를 추가한다
            failMove(answer, upperCurrentBridge, lowerCurrentBridge, userMovingValue, i);
            if (upperCurrentBridge.contains("X")) {

            }
            if (lowerCurrentBridge.contains("X")) {

            }
            outputView.printMap(upperCurrentBridge); // 추가된 다리를 출력한다
            outputView.printMap(lowerCurrentBridge);
        }
    }
}
