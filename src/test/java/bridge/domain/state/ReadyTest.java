package bridge.domain.state;

import bridge.domain.MoveResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("다리를 건너기 성공")
    void moveResult() {
        assertThat(ready.move(1)).isExactlyInstanceOf(Success.class);
    }
}
