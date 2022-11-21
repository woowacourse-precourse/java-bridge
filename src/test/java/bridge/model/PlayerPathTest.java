package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerPathTest {

    static PlayerPath playerPath;

    @BeforeAll
    static void beforeAll() {
        playerPath = new PlayerPath();
        playerPath.nextStep(Plate.UP_PLATE);
        playerPath.nextStep(Plate.DOWN_PLATE);
        playerPath.nextStep(Plate.UP_PLATE);
    }

    @DisplayName("다음칸으로 넘어가는 테스트")
    @Test
    void nextStepTest() {
        List<Plate> playerPlates = playerPath.getPlayerPath();
        assertThat(playerPlates)
                .containsExactly(Plate.UP_PLATE, Plate.DOWN_PLATE, Plate.DOWN_PLATE);
    }

    @DisplayName("경로에서 현재 위치와 발판을 가져오는 테스트")
    @Test
    void  currentPositionAndPlateTest() {
        Plate currentPlate = playerPath.currentPlate();
        int currentPosition = playerPath.currentPosition();

        assertThat(currentPlate).isEqualTo(Plate.UP_PLATE);
        assertThat(currentPosition).isEqualTo(2);
    }
}
