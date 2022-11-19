package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeTest {
    Bridge bridge;

    @BeforeEach
    void setBridge() {
        bridge = new Bridge(Arrays.asList("D", "U", "U"));
    }

    @Test
    void 이동칸_비교_테스트() {
        List<String> input = Arrays.asList("D", "U");
        List<String> input2 = Arrays.asList("D", "U", "D");

        assertThat(bridge.compare(input)).isTrue();
        assertThat(bridge.compare(input2)).isFalse();
    }
}