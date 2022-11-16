package bridge.domain.state;

import bridge.constant.ErrorMessageConstant;
import bridge.domain.MoveResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class ReadyTest {
    private Ready ready;
    
    @BeforeEach
    void setUp() {
        ready = new Ready(List.of("X", "U", "X"));
    }
    
    @Test
    @DisplayName("Ready 상태 반환하기")
    void stateInformation() {
        assertThat(new Ready(List.of()).state()).isEqualTo(MoveResult.READY);
    }
    
    @Test
    @DisplayName("다리 건너기 성공")
    void moveSuccess() {
        assertThat(ready.move(1)).isExactlyInstanceOf(Success.class);
    }
    
    @Test
    @DisplayName("다리 건너기 실패")
    void moveFail() {
        assertThat(ready.move(0)).isExactlyInstanceOf(Fail.class);
    }
    
    @Test
    @DisplayName("예외 처리 : 재시도 여부 선택 상태를 판별하는 기능 사용 시")
    void retryState() {
        assertThatIllegalStateException()
                .isThrownBy(() -> new Ready(List.of()).isMoveFail())
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}
