package bridge.model;

import bridge.model.dto.MapDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class MapMakerTest {

    MapMaker mapMaker = new MapMaker(List.of("O", " ", "O"), List.of(" ", "O", " "));

    @DisplayName("지도 생성 기능 테스트")
    @Test
    void makeMap() {
        MapDto result = mapMaker.makeMap();

        Assertions.assertThat(result.getUpsideMap()).isEqualTo("[ O |   | O ]");
        Assertions.assertThat(result.getDownsideMap()).isEqualTo("[   | O |   ]");
    }
}