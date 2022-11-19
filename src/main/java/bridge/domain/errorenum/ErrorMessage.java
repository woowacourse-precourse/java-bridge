package bridge.domain.errorenum;

import bridge.domain.bridgeenum.BridgeCondition;
import bridge.domain.bridgeenum.MoveCondition;
import bridge.domain.bridgeenum.Restart;

public enum ErrorMessage {
    HEAD("[ERROR] "),
    NOT_NUMBER("다리 길이는 자연수만 입력할 수 있습니다."),
    NOT_IN_RANGE(String.format("다리 길이는 %d이상 %d 이하 여야 합니다.", BridgeCondition.MIN.getValue(), BridgeCondition.MAX.getValue())),
    NOT_UPPER_CASE("알파벳 대문자만 입력할 수 있습니다."),
    NOT_IN_MOVE_CONDITION(String.format("이동할 칸은 %s, %s 중 하나만 선택할 수 있습니다.", MoveCondition.UPPER.getPosition(), MoveCondition.LOWER.getPosition())),
    NOT_IN_RESTART(String.format("재시작 (%s), 종료 (%s) 중 하나만 선택할 수 있습니다.", Restart.RESTART.getCommand(), Restart.END.getCommand()));

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String printMessage() {
        return HEAD.value + value;
    }
}
