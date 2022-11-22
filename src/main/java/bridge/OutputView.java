package bridge;

import constants.Output;
import constants.Symbol;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart() {
        System.out.println(Output.START_MSG.getMsg());
    }

    public void printBridgeSize() {
        System.out.println(Output.BRIDGE_SIZE_MSG.getMsg());
    }

    public void printMoving() {
        System.out.println(Output.MOVING_MSG.getMsg());
    }

    public void printGameCommand() {
        System.out.println(Output.GAME_COMMAND_MSG.getMsg());
    }

    public void printEnd() {
        System.out.println(Output.END_MSG.getMsg());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String currentBridge) {
        System.out.print(Symbol.START.getSymbol());
        System.out.print(currentBridge);
        System.out.println(Symbol.END.getSymbol());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean result, int numberOfTimes) {
        if (result) {
            System.out.println(String.format(Output.RESULT_MSG.getMsg(), Output.SUCCESS_MSG.getMsg()));
        }
        if (!result) {
            System.out.println(String.format(Output.RESULT_MSG.getMsg(), Output.FAIL_MSG.getMsg()));
        }
        System.out.println(String.format(Output.NUMBER_OF_TIMES_MSG.getMsg(), numberOfTimes));
    }
}
