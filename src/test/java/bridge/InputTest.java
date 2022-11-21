package bridge;

import bridge.model.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("사용자의 이동 방향의 입력에 따른 기능 테스트")
    @Test
    void 이동_입력_테스트(){
        assertThat(true).isEqualTo(Validation.moveDirectionTest("U"));
        assertThat(true).isEqualTo(Validation.moveDirectionTest("D"));
        assertThat(false).isEqualTo(Validation.moveDirectionTest("9"));
        assertThat(false).isEqualTo(Validation.moveDirectionTest("70"));
        assertThat(false).isEqualTo(Validation.moveDirectionTest("u"));
        assertThat(false).isEqualTo(Validation.moveDirectionTest("x"));
    }
    @DisplayName("게임을 다시 진행 할지에 대한 입력에 따른 기능 테스트")
    @Test
    void 재시도에_대한_테스트(){
        assertThat(true).isEqualTo(Validation.retryTest("R"));
        assertThat(true).isEqualTo(Validation.retryTest("Q"));
        assertThat(false).isEqualTo(Validation.retryTest("9"));
        assertThat(false).isEqualTo(Validation.retryTest("70"));
        assertThat(false).isEqualTo(Validation.retryTest("r"));
        assertThat(false).isEqualTo(Validation.retryTest("X"));
    }
}