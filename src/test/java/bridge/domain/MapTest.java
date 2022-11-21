package bridge.domain;

import bridge.constant.BridgeSymbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {
    private Map map;

    @BeforeEach
    void setMap() {
        map = new Map();
    }

    @DisplayName("O 결과를 위쪽 다리에 추가한다.")
    @Test
    void createOInUpBridge() {
        String result = BridgeSymbol.O.getState();

        map.makeUpMap(result);
        String upExpected = "[ O ]";
        String downExpected = "[   ]";

        assertThat(map.getUpMap()).isEqualTo(upExpected);
        assertThat(map.getDownMap()).isEqualTo(downExpected);
    }

    @DisplayName("X 결과를 위쪽 다리에 추가한다.")
    @Test
    void createXInUpBridge() {
        String result = BridgeSymbol.X.getState();

        map.makeUpMap(result);
        String upExpected = "[ X ]";
        String downExpected = "[   ]";

        assertThat(map.getUpMap()).isEqualTo(upExpected);
        assertThat(map.getDownMap()).isEqualTo(downExpected);
    }

    @DisplayName("O 결과를 아래쪽 다리에 추가한다.")
    @Test
    void createOInDownBridge() {
        String result = BridgeSymbol.O.getState();

        map.makeDownMap(result);
        String upExpected = "[   ]";
        String downExpected = "[ O ]";

        assertThat(map.getUpMap()).isEqualTo(upExpected);
        assertThat(map.getDownMap()).isEqualTo(downExpected);
    }

    @DisplayName("X 결과를 아래쪽 다리에 추가한다.")
    @Test
    void createXInDownBridge() {
        String result = BridgeSymbol.X.getState();

        map.makeDownMap(result);
        String upExpected = "[   ]";
        String downExpected = "[ X ]";

        assertThat(map.getUpMap()).isEqualTo(upExpected);
        assertThat(map.getDownMap()).isEqualTo(downExpected);
    }
}
