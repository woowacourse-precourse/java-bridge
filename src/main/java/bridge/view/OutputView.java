package bridge.view;

import bridge.controller.BridgeGame;
import bridge.domain.Bridge;
import bridge.domain.User;
import org.junit.jupiter.params.ParameterizedTest;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {
    public static void print(String message) {
        System.out.print(message);
    }

    public static void printLine(String message) {
        System.out.println(message);
    }

    public static void printMapEachLine(String line, Bridge bridge, User user) {
        print(BridgeOutput.LEFT_BRACKET);
        for(int i=0 ; i< user.getPosition() ; i++) {
            print(printSuccessOrFail(line, bridge.getIndexResult(i), user.getIndexSelect(i)));
            if(i == user.getPosition()-2) print(BridgeOutput.SPLIT);
        }
        print(BridgeOutput.RIGHT_BRACKET);
    }

    public static String printSuccessOrFail(String line, String bridge, String user) {
        if(line.equals(bridge)) {
            if(bridge.equals(user)) return BridgeOutput.CORRECT_SYMBOL;
            if(!bridge.equals(user)) return BridgeOutput.FAIL_SYMBOL;
        }

        return BridgeOutput.BLANK_SYMBOL;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(Bridge bridge, User user) {
        printMapEachLine(BridgeOutput.FIRST_LINE_CHARACTER, bridge, user);
        printLine("");
        printMapEachLine(BridgeOutput.SECOND_LINE_CHARACTER, bridge, user);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {

    }
}
