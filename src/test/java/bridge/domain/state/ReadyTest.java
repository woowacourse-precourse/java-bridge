package bridge.domain.state;

import bridge.constant.ErrorMessageConstant;
import bridge.domain.MoveResult;
import bridge.domain.factory.BridgeMakerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class ReadyTest {
    private State upperReady;
    private State lowerReady;
    
    @BeforeEach
    void setUp() {
        upperReady = new Ready(BridgeMakerTest.UPPER_BRIDGE_MAKER.makeBridge(3));
        lowerReady = new Ready(BridgeMakerTest.LOWER_BRIDGE_MAKER.makeBridge(3));
    }
    
    @Test
    @DisplayName("다리 건너기 성공")
    void moveSuccess() {
        assertThat(upperReady.move(1, "U")).isExactlyInstanceOf(Success.class);
    }
    
    @Test
    @DisplayName("다리 건너기 실패")
    void moveFail() {
        assertThat(lowerReady.move(2, "U")).isExactlyInstanceOf(Fail.class);
    }
    
    @Test
    @DisplayName("예외 처리 : Ready 상태에서 현재 상태를 알리려 할 경우")
    void stateInformation() {
        assertThatIllegalStateException()
                .isThrownBy(() -> upperReady.state())
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("예외 처리 : 재시도 여부 선택 상태를 판별하는 기능 사용 시")
    void isRetry() {
        assertThatIllegalStateException()
                .isThrownBy(() -> new Ready(List.of()).isMoveFail())
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("예외 처리 : 게임 종료 여부 선택 상태를 판별하는 기능 사용 시")
    void isGameFinished() {
        assertThatIllegalStateException()
                .isThrownBy(() -> new Ready(List.of()).isGameFinished(2))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}
