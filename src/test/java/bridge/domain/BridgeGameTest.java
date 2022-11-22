package bridge.domain;

import bridge.dto.CorrectInfo;
import bridge.global.BridgeMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach(){
        bridgeGame = new BridgeGame();
    }

    @Test
    public void moveTest() throws Exception{
        //given
        String userInput = "U";
        String blockInput = "D";
        //when
        CorrectInfo move = bridgeGame.move(blockInput, userInput);
        BridgeMessage bridgeBlock = move.getBridgeBlock();
        //then
        assertThat(move.isPass()).isEqualTo(false);
        assertThat(move.isFail()).isEqualTo(true);
        assertThat(bridgeBlock.getMessage()).isIn("U","D");
    }
}