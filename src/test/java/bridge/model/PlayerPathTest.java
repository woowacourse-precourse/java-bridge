package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerPathTest {

    @DisplayName("다음칸으로 넘어가는 테스트")
    @Test
    void nextStepTest() {
        PlayerPath playerPath = new PlayerPath();
        playerPath.nextStep(Plate.UP_PLATE);
        playerPath.nextStep(Plate.DOWN_PLATE);
        playerPath.nextStep(Plate.UP_PLATE);
        List<Plate> playerPlates = playerPath.getPlayerPath();

        assertThat(playerPlates)
                .containsExactly(Plate.UP_PLATE, Plate.DOWN_PLATE, Plate.DOWN_PLATE);
    }

    
}
