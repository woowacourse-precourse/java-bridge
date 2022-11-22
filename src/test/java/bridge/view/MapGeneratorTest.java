package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapGeneratorTest {
    private MapGenerator mapGenerator;

    @BeforeEach
    public void initialize() {
        mapGenerator = new MapGenerator();
        mapGenerator.initializeMap();
    }

    @DisplayName("다리의 상태에 따라 맵이 잘 만들어지는지 테스트")
    @Test
    public void makeMapTest() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> bridgeStatus = List.of("O", "O", "O");
        mapGenerator.makeMap(bridge, bridgeStatus);

        Assertions.assertThat(mapGenerator.getUpperMap()).isEqualTo("[ O |   | O ]");
    }

    @DisplayName("다리의 상태에 따라 맵에 O가 잘 표시되는지 테스트")
    @Test
    public void addOToMapTest() {
        List<String> bridge = List.of("U");
        List<String> bridgeStatus = List.of("O");
        int idx = 0;
        mapGenerator.addOToMap(bridge, bridgeStatus, idx);

        Assertions.assertThat(mapGenerator.getUpperMap()).isEqualTo("[ O");
    }

    @DisplayName("다리의 상태에 따라 맵에 구분선이 잘 표시되는지 테스트")
    @Test
    public void continueMapTest() {
        List<String> bridgeStatus = List.of("O");
        int size = 2;
        int idx = 0;
        mapGenerator.continueOrFinishMap(bridgeStatus, size, idx);

        Assertions.assertThat(mapGenerator.getUpperMap()).isEqualTo("[ |");
    }

    @DisplayName("다리의 끝에 도달했을 때 괄호가 잘 닫히는지 테스트")
    @Test
    public void finishMapTest() {
        List<String> bridgeStatus = List.of("O");
        int size = 1;
        int idx = 0;
        mapGenerator.continueOrFinishMap(bridgeStatus, size, idx);

        Assertions.assertThat(mapGenerator.getUpperMap()).isEqualTo("[ ]");
    }

    @DisplayName("다리의 상태에 따라 맵에 X가 표시되고 괄호가 잘 닫히는지 테스트")
    @Test
    public void addXAndFinishMapTest() {
        List<String> bridge = List.of("U");
        List<String> bridgeStatus = List.of("X");
        int idx = 0;
        mapGenerator.addXAndFinishMap(bridge, bridgeStatus, idx);

        Assertions.assertThat(mapGenerator.getLowerMap()).isEqualTo("[ X ]");
    }
}

