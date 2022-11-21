package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class BridgeTest {

    List<String> answerBridge = List.of("U","D","D","U","D");
    Bridge bridge = new Bridge(answerBridge);

    @ParameterizedTest
    @CsvSource({"3,U,true", "3,D,false", "1,U,false", "0,D,false"})
    void isRightDirection(int idx, String direction, boolean result) {
        Assertions.assertThat(bridge.isRightDirection(idx,direction)).isEqualTo(result);
    }

}