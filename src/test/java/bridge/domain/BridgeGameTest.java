package bridge.domain;

import bridge.domain.strategy.BridgeNumberGeneratorTest;
import bridge.dto.BridgeSizeDTO;
import bridge.dto.MovingDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private BridgeGame bridgeGame;
    
    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(BridgeNumberGeneratorTest.BRIDGE_NUMBER_GENERATOR_ONE, new BridgeSizeDTO(2));
        bridgeGame.move(new MovingDTO("U"));
    }
    
    @Test
    @DisplayName("이동 확인")
    void move() {
        bridgeGame.move(new MovingDTO("U"));
        assertThat(bridgeGame.isGameFinished()).isTrue();
    }
    
    @Test
    @DisplayName("게임 종료인지 확인")
    void isGameFinished() {
        assertAll(
                () -> assertThat(bridgeGame.isGameFinished()).isFalse(),
                () -> bridgeGame.move(new MovingDTO("U")),
                () -> assertThat(bridgeGame.isGameFinished()).isTrue()
        );
    }
    
    @Test
    @DisplayName("초기화 되는지 확인")
    void retry() {
        bridgeGame.move(new MovingDTO("U"));
        
        assertAll(
                () -> assertThat(bridgeGame.isGameFinished()).isTrue(),
                () -> bridgeGame.retry(),
                () -> assertThat(bridgeGame.isGameFinished()).isFalse()
        );
    }
    
    @Test
    @DisplayName("이동을 실패했는지 확인")
    void isMoveFail() {
        assertAll(
                () -> assertThat(bridgeGame.isMoveFail()).isFalse(),
                () -> bridgeGame.move(new MovingDTO("D")),
                () -> assertThat(bridgeGame.isMoveFail()).isTrue()
        );
    }
}