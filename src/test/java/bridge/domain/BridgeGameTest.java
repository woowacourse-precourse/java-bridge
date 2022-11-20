package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setting(){
        bridgeGame = new BridgeGame(List.of("U", "D", "U"));
    }

    @DisplayName("이동할 칸 입력값에 따라 다리 이동을 진행한다.")
    @Test
    void moveTest(){
        String input = "U";
        assertThat(bridgeGame.move(input)).isEqualTo(List.of("O"));
    }

}
