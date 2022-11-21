package bridge.model;

import bridge.model.data.MapData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class MapMakerTest {

    MapMaker mapMaker = new MapMaker(List.of("O", " ", "O"), List.of(" ", "O", " "));

    @Test
    void makeMap() {
        MapData result = mapMaker.makeMap();

        Assertions.assertThat(result.getUpsideMap()).isEqualTo("[ O |   | O ]");
        Assertions.assertThat(result.getDownsideMap()).isEqualTo("[   | O |   ]");
    }
}