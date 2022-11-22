package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MovementResultTest {

    @Test
    @DisplayName("정상적인 다리 건너기 성공 결과 값에 O 포함")
    void successBridge(){
        MovementResult upperMovementResult = new MovementResult();
        MovementResult downMovementResult = new MovementResult();
        upperMovementResult.setResults(true);
        downMovementResult.addBlank();

        assertThat(upperMovementResult.toString()).contains("[ O ]");
        assertThat(downMovementResult.toString()).contains("[   ]");
    }

    @Test
    @DisplayName("정상적인 다리 건너기 실패 결과 값에 X 포함")
    void failBridge(){
        MovementResult upperMovementResult = new MovementResult();
        MovementResult downMovementResult = new MovementResult();
        upperMovementResult.setResults(false);
        downMovementResult.addBlank();

        assertThat(upperMovementResult.toString()).contains("[ X ]");
        assertThat(downMovementResult.toString()).contains("[   ]");
    }

    @Test
    @DisplayName("다리 리셋")
    void resetBridge(){
        MovementResult upperMovementResult = new MovementResult();
        MovementResult downMovementResult = new MovementResult();

        upperMovementResult.reset();
        downMovementResult.reset();

        assertThat(upperMovementResult.toString()).contains("[  ]");
        assertThat(downMovementResult.toString()).contains("[  ]");
    }
}