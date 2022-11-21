package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlateTest {

    @DisplayName("랜덤 넘버(0, 1)로 놓을 다리 Plate 찾는 테스트")
    @Test
    void randomPlateTest() {
        Plate zeroPlate = Plate.findByRandomNumber(0);
        Plate onePlate = Plate.findByRandomNumber(1);

        assertThat(zeroPlate).isEqualTo(Plate.DOWN_PLATE);
        assertThat(onePlate).isEqualTo(Plate.UP_PLATE);
    }

    @DisplayName("입력한 U, D 통해서 Plate 찾는 테스트")
    @Test
    void inputPlateTest() {
        Plate upPlate = Plate.findBySymbol("U");
        Plate downPlate = Plate.findBySymbol("D");

        assertThat(downPlate).isEqualTo(Plate.DOWN_PLATE);
        assertThat(upPlate).isEqualTo(Plate.UP_PLATE);
    }
}
