package bridge;

import bridge.EnumClass.EnumConstant;
import bridge.EnumClass.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BridgeTest {
    @DisplayName("다리 생성 시 input 타입 오류입니다.")
    @Test
    void 다리_생성_타입_예외() {
        assertThatThrownBy(() -> Validator.validateBridgeInput("jp"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 생성 시 input 크기 오류입니다.")
    @Test
    void 다리_생성_크기_예외() {
        assertThatThrownBy(() -> Validator.validateBridgeInput("25"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 커맨드 입력 시 체크 오류입니다")
    @Test
    void 움직임_입력_예외() {
        assertThatThrownBy(() -> Validator.validateCommand("P", EnumConstant.State_Move))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
