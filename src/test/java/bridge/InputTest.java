package bridge;

import bridge.model.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    @DisplayName("사용자의 다리 사이즈 입력에 따른 기능 테스트 ")
    @Test
    void 다리_사이즈_입력_테스트() {
        assertThat(true).isEqualTo(Validation.bridgeSizeValidationTest("10"));
        assertThat(false).isEqualTo(Validation.bridgeSizeValidationTest("a1"));
        assertThat(false).isEqualTo(Validation.bridgeSizeValidationTest("a"));
        //TODO : -1를 \\d 에 속하지 않아서 숫자를 입력해달라고 나오는 것을 수정하자!
        assertThat(false).isEqualTo(Validation.bridgeSizeValidationTest("-1"));
        assertThat(false).isEqualTo(Validation.bridgeSizeValidationTest("50"));
    }
}