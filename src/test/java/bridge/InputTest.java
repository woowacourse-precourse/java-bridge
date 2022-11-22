package bridge;

import bridge.model.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class InputTest {
    @DisplayName("사용자의 다리 사이즈 입력에 따른 기능 테스트 ")
    @Test
    void 다리_사이즈_입력_테스트() {
        assertThat(true).isEqualTo(Validation.bridgeSizeVerification("10"));
        assertThat(false).isEqualTo(Validation.bridgeSizeVerification("a1"));
        assertThat(false).isEqualTo(Validation.bridgeSizeVerification("a"));
        assertThat(false).isEqualTo(Validation.bridgeSizeVerification("-1"));
        assertThat(false).isEqualTo(Validation.bridgeSizeVerification("50"));
    }
    @DisplayName("사용자의 이동 방향의 입력에 따른 기능 테스트")
    @Test
    void 이동_입력_테스트(){
        assertThat(true).isEqualTo(Validation.moveDirectionVerification("U"));
        assertThat(true).isEqualTo(Validation.moveDirectionVerification("D"));
        assertThat(false).isEqualTo(Validation.moveDirectionVerification("9"));
        assertThat(false).isEqualTo(Validation.moveDirectionVerification("70"));
        assertThat(false).isEqualTo(Validation.moveDirectionVerification("u"));
        assertThat(false).isEqualTo(Validation.moveDirectionVerification("x"));
    }
    @DisplayName("게임을 다시 진행 할지에 대한 입력에 따른 기능 테스트")
    @Test
    void 재시도에_대한_테스트(){
        assertThat(true).isEqualTo(Validation.retryValueVerification("R"));
        assertThat(true).isEqualTo(Validation.retryValueVerification("Q"));
        assertThat(false).isEqualTo(Validation.retryValueVerification("9"));
        assertThat(false).isEqualTo(Validation.retryValueVerification("70"));
        assertThat(false).isEqualTo(Validation.retryValueVerification("r"));
        assertThat(false).isEqualTo(Validation.retryValueVerification("X"));
    }
}