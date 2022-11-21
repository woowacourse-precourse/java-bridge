package bridge.domain;

import bridge.dto.MovingDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MovingResultStatesTest {
    private MoveResultStates moveResultStates;
    
    @BeforeEach
    void setUp() {
        moveResultStates = new MoveResultStates();
        moveResultStates.move(new MovingDTO("U"), BridgeTest.UPPER_BRIDGE);
    }
    
    @Test
    @DisplayName("이동 확인")
    void move() {
        moveResultStates.move(new MovingDTO("U"), BridgeTest.UPPER_BRIDGE);
        assertThat(moveResultStates.isGameFinished()).isTrue();
    }
    
    @Test
    @DisplayName("게임 종료인지 확인")
    void isGameFinished() {
        assertAll(
                () -> assertThat(moveResultStates.isGameFinished()).isFalse(),
                () -> moveResultStates.move(new MovingDTO("U"), BridgeTest.UPPER_BRIDGE),
                () -> assertThat(moveResultStates.isGameFinished()).isTrue()
        );
    }
    
    @Test
    @DisplayName("초기화 되는지 확인")
    void retry() {
        moveResultStates.move(new MovingDTO("U"), BridgeTest.UPPER_BRIDGE);
        
        assertAll(
                () -> assertThat(moveResultStates.isGameFinished()).isTrue(),
                () -> moveResultStates.initMovingStates(),
                () -> assertThat(moveResultStates.isGameFinished()).isFalse()
        );
    }
    
    @Test
    @DisplayName("이동을 실패했는지 확인")
    void isMoveFail() {
        assertAll(
                () -> assertThat(moveResultStates.isMoveFail()).isFalse(),
                () -> moveResultStates.move(new MovingDTO("D"), BridgeTest.UPPER_BRIDGE),
                () -> assertThat(moveResultStates.isMoveFail()).isTrue()
        );
    }
}