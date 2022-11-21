package bridge.domain;

import bridge.dto.MovingDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MovingResultStatesTest {
    private MovingResultStates movingResultStates;
    
    @BeforeEach
    void setUp() {
        movingResultStates = new MovingResultStates();
        movingResultStates.move(new MovingDTO("U"), BridgeTest.UPPER_BRIDGE);
    }
    
    @Test
    @DisplayName("이동 확인")
    void move() {
        movingResultStates.move(new MovingDTO("U"), BridgeTest.UPPER_BRIDGE);
        assertThat(movingResultStates.isGameFinished()).isTrue();
    }
    
    @Test
    @DisplayName("게임 종료인지 확인")
    void isGameFinished() {
        assertAll(
                () -> assertThat(movingResultStates.isGameFinished()).isFalse(),
                () -> movingResultStates.move(new MovingDTO("U"), BridgeTest.UPPER_BRIDGE),
                () -> assertThat(movingResultStates.isGameFinished()).isTrue()
        );
    }
    
    @Test
    @DisplayName("초기화 되는지 확인")
    void retry() {
        movingResultStates.move(new MovingDTO("U"), BridgeTest.UPPER_BRIDGE);
        
        assertAll(
                () -> assertThat(movingResultStates.isGameFinished()).isTrue(),
                () -> movingResultStates.initMovingStates(),
                () -> assertThat(movingResultStates.isGameFinished()).isFalse()
        );
    }
    
    @Test
    @DisplayName("이동을 실패했는지 확인")
    void isMoveFail() {
        assertAll(
                () -> assertThat(movingResultStates.isMoveFail()).isFalse(),
                () -> movingResultStates.move(new MovingDTO("D"), BridgeTest.UPPER_BRIDGE),
                () -> assertThat(movingResultStates.isMoveFail()).isTrue()
        );
    }
}