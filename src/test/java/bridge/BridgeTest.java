package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        List<String> input3 = Arrays.asList("U");

        assertThat(bridge.compareUserInput(input)).isEqualTo("O");
        assertThat(bridge.compareUserInput(input2)).isEqualTo("X");
        assertThat(bridge.compareUserInput(input3)).isEqualTo("X");
    }

    @ParameterizedTest
    @CsvSource({"true,O","false,X"})
    void 비교_사인_변환_테스트(boolean comparison, String sign) {
        assertThat(bridge.getSign(comparison)).isEqualTo(sign);
    }
}