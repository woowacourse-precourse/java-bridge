package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMapTest {
    private final BridgeMap bridgeMap = new BridgeMap();

    @ParameterizedTest
    @CsvSource(value = {"false:U:X", "true:D:O", "true:U:O"}, delimiter = ':')
    void create_map(boolean isMove, String moving, String result) {
        bridgeMap.createMap(isMove, moving);
        assertThat(bridgeMap.getMap())
                .hasSize(2)
                .extracting(moving, String.class).contains(List.of(result));
    }

}