package bridge.system.validation;

import bridge.vo.Step;

import java.util.List;

public class InputToMovingPointValidator extends RegexContainingOnlyValidator {
    public static final String INVALID_INPUT_VALUE_MESSAGE
            = String.format("이동할 칸으로는 대문자 %s 또는 %s 둘 중 하나만 입력하실 수 있습니다.", Step.U, Step.D);

    public static void validate(String target) {
        isOnlyConsistedOf(target, INVALID_INPUT_VALUE_MESSAGE,
                List.of(Step.U.toString(), Step.D.toString()));
    }
}
