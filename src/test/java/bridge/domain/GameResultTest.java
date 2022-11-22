package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
    }

    @Test
    void setGameResult() {
        assertThatThrownBy(() -> gameResult.setUpBridgeResult("R"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gameResult.setDownBridgeResult("D"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}