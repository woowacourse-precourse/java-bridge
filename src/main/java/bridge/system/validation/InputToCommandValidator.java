package bridge.system.validation;

import bridge.vo.enums.Command;

import java.util.List;

public class InputToCommandValidator extends RegexContainingOnlyValidator {
    public static final String INVALID_INPUT_VALUE_MESSAGE
            = String.format("게임 재시작/종료 여부로는 대문자 %s 또는 %s 둘 중 하나만 입력하실 수 있습니다.", Command.R, Command.Q);

    public static void validate(String target) {
        isOnlyConsistedOf(
                target, INVALID_INPUT_VALUE_MESSAGE,
                List.of(Command.R.toString(), Command.Q.toString())
        );
    }
}
