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
        List<String> firstInput = Arrays.asList("D", "U");
        List<String> secondInput = Arrays.asList("D", "U", "D");
        List<String> thirdInput = Arrays.asList("U");

        assertThat(bridge.compareUserInput(firstInput)).isEqualTo("O");
        assertThat(bridge.compareUserInput(secondInput)).isEqualTo("X");
        assertThat(bridge.compareUserInput(thirdInput)).isEqualTo("X");
    }

    @ParameterizedTest
    @CsvSource({"true,O","false,X"})
    void 비교_사인_변환_테스트(boolean comparison, String sign) {
        String input = bridge.getSign(comparison);
        assertThat(input).isEqualTo(sign);
    }

    @Test
    void 길이_비교_테스트() {
        boolean falseInput = bridge.compareLength(Arrays.asList("U"));
        boolean trueInput = bridge.compareLength(Arrays.asList("D", "U", "U"));

        assertThat(falseInput).isFalse();
        assertThat(trueInput).isTrue();
    }

    @Test
    void 비교_인덱스_획득_테스트() {
        int input = bridge.getCompareIndex(Arrays.asList("D", "U", "U"));
        int expected = 2;

        assertThat(input).isEqualTo(expected);
    }
}