package bridge.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    @Test
    void 브리지_생성_테스트() {
        List<String> bridgeStrs = List.of("D","U","D");
        Bridge bridge = new Bridge(bridgeStrs);
        assertThat(bridge.getBridgeSpaces().size()).isEqualTo(bridgeStrs.size());
    }


}