package bridge.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeResultTest {

    @ParameterizedTest
    @CsvSource(value = {"U:U:U:[ O |   | O ]:[   | X |   ]"
                        , "U:D:D:[ O |   | X ]:[   | O |   ]"
                        , "U:D:U:[ O |   | O ]:[   | O |   ]"}, delimiter = ':')
    void matchBridge5(String str1, String str2, String str3, String expectedUp, String expectedDown) {
        BridgeResult bridgeResult = new BridgeResult(List.of("U", "D", "U"));
        String result = bridgeResult.matchBridge(List.of(str1, str2, str3));
        System.out.println(result);
        assertThat(result).isEqualTo(expectedUp + "\n" + expectedDown);
    }

}