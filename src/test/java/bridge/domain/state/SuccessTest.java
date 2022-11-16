package bridge.domain.state;

import bridge.constant.ErrorMessageConstant;
import bridge.domain.MoveResult;
import bridge.domain.factory.BridgeMakerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class SuccessTest {
    private State success;
    
    @BeforeEach
    void setUp() {
        success = new Success(BridgeMakerTest.UPPER_BRIDGE_MAKER.makeBridge(3));
    }
    
    @Test
    @DisplayName("예외 처리 : 이동을 시도할 시")
    void move() {
        assertThatIllegalStateException()
                .isThrownBy(() -> success.move(2))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("Success 상태 반환하기")
    void stateInformation() {
        assertThat(success.state()).isEqualTo(MoveResult.SUCCESS);
    }
    
    @Test
    @DisplayName("재시도 여부 선택 상태 아님")
    void isRetry() {
        assertThat(success.isMoveFail()).isFalse();
    }
    
    @DisplayName("게임 종료 상태 체크")
    @ParameterizedTest(name = "{displayName} : numberOfMoves => {0}, result => {1}")
    @CsvSource(value = {"2, true", "1, false"})
    void isGameFinished(final int numberOfMoves, final boolean result) {
        assertThat(success.isGameFinished(numberOfMoves)).isEqualTo(result);
    }
}