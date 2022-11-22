package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.dto.BridgeGameDto;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @BeforeEach
    void init(){
        BridgeGame.initializeValues();
    }
    @Test
    void isCorrectGuess_기능테스트() {
        Bridge bridge = new Bridge(Arrays.asList("U","D","U"));
        BridgeGame bridgeGame = new BridgeGame();

        bridgeGame.move("U");
        bridgeGame.move("D");
        BridgeGameDto bridgeGameDto = bridgeGame.sendDto();
        assertThat(bridge.isCorrectGuess(bridgeGameDto))
                .isEqualTo(true);
        BridgeGame.initializeValues();
    }

}
