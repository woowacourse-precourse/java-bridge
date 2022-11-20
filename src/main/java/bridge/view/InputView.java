package bridge.view;

import bridge.BridgeRule;
import bridge.MoveRule;
import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    OutputView outputView = new OutputView();

    public String readValue() {
        return Console.readLine();
    }

    private int convertToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력하신 값은 정수가 아닙니다.");
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = convertToInteger(readValue());
        if (bridgeSize < BridgeRule.MIN_LENGTH.getValue() || bridgeSize > BridgeRule.MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException("다리 길이는 3 이상 20 이하여야 합니다!");
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = readValue();
        if (move.equals(MoveRule.MOVE_UP.getMove()) || !move.equals(MoveRule.MOVE_DOWN.getMove())) {
            throw new IllegalArgumentException("허용되지 않는 값! U(위쪽) D(아래쪽) 중 하나를 입력하셔야 합니다!");
        }
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = readValue();
        if (Objects.equals(command, "Q") || Objects.equals(command, "R")) {
            throw new IllegalArgumentException("허용되지 않는 값! R(재시작) Q(종료) 중 하나를 입력하셔야 합니다!");
        }
        return command;
    }
}
