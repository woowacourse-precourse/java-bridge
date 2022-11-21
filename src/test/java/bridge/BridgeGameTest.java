package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @Test
    void 이동가능시_참_반환() {
        //given
        String movingDirection = "U";
        List<String> route = new ArrayList<>(List.of("U", "D", "U"));

        //when
        route = bridgeGame.move(movingDirection, route);

        //then
        Assertions.assertThat(route).isEqualTo(List.of("U", "D", "U", "U"));
    }

}