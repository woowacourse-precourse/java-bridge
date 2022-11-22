package bridge.domain.state;

import bridge.constant.ErrorMessageConstant;
import bridge.domain.BridgeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class ReadyTest {
    private MovingResultState upperReady;
    private MovingResultState lowerReady;
    
    @BeforeEach
    void setUp() {
        upperReady = new Ready(BridgeTest.UPPER_BRIDGE);
        lowerReady = new Ready(BridgeTest.LOWER_BRIDGE);
    }
    
    @Test
    @DisplayName("다리 건너기 성공")
    void moveSuccess() {
        assertThat(upperReady.move(1, "U")).isExactlyInstanceOf(Success.class);
    }
    
    @Test
    @DisplayName("다리 건너기 실패")
    void moveFail() {
        assertThat(lowerReady.move(1, "U")).isExactlyInstanceOf(Fail.class);
    }
    
    @Test
    @DisplayName("예외 처리 : 재시도 여부 선택 상태를 판별하는 기능 사용 시")
    void isRetry() {
        assertThatIllegalStateException()
                .isThrownBy(() -> upperReady.isMoveFailed())
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("예외 처리 : 게임 종료 여부 선택 상태를 판별하는 기능 사용 시")
    void isGameFinished() {
        assertThatIllegalStateException()
                .isThrownBy(() -> upperReady.isGameFinished(2))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}
