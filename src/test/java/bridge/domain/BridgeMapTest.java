package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMapTest {
    private final BridgeMap bridgeMap = new BridgeMap();

    @ParameterizedTest
    @DisplayName("다리의_지도_생성_후_내부_검사")
    @CsvSource(value = {"false:U:X", "true:D:O", "true:U:O"}, delimiter = ':')
    void create_map(boolean isMove, String moving, String result) {
        bridgeMap.createMap(isMove, moving);
        assertThat(bridgeMap.getMap())
                .hasSize(2)
                .extracting(moving, String.class).contains(List.of(result));
    }

    @Test
    @DisplayName("지도_초기화_시키기")
    void initialization() {
        bridgeMap.createMap(false, "U");
        bridgeMap.initialization();
        assertThat(bridgeMap.getMap())
                .hasSize(2)
                .contains(entry("U", new ArrayList<>()), entry("D", new ArrayList<>()));
    }

}