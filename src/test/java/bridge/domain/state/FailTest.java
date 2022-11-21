package bridge.domain.state;

import bridge.constant.ErrorMessageConstant;
import bridge.domain.BridgeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class FailTest {
    private MoveResultState fail;
    
    @BeforeEach
    void setUp() {
        fail = new Fail(BridgeTest.LOWER_BRIDGE, "U");
    }
    
    @Test
    @DisplayName("예외 처리 : 이동을 시도할 시")
    void move() {
        assertThatIllegalStateException()
                .isThrownBy(() -> fail.move(2, "U"))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("재시도 여부 선택 상태 맞음")
    void isRetry() {
        assertThat(fail.isMoveFailed()).isTrue();
    }
    
    @Test
    @DisplayName("게임 종료 상태 아님")
    void isGameFinished() {
        assertThat(fail.isGameFinished(2)).isFalse();
    }
}