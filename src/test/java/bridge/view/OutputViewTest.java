package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OutputViewTest {
    private OutputView outputView;

    @BeforeEach
    public void initialize() {
        outputView = new OutputView();
        outputView.initializeMap();
    }

    @DisplayName("다리의 상태에 따라 맵에 O가 잘 표시되는지 테스트")
    @Test
    public void addOToMapTest() {
        List<String> bridge = List.of("U");
        List<String> bridgeStatus = List.of("O");
        int idx = 0;
        outputView.addOToMap(bridge, bridgeStatus, idx);

        Assertions.assertThat(outputView.getUpperMap()).isEqualTo("[ O");
    }
}

