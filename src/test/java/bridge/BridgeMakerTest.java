package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("다리 생성 - 생성된 다리 리스트의 길이는 입력된 숫자와 같아야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 20})
    void madeBridgeLengthTest(int lengthOfBridge) {
        List<String> madeBridge = bridgeMaker.makeBridge(lengthOfBridge);

        assertThat(madeBridge).hasSize(lengthOfBridge);
    }

    @DisplayName("다리 생성 - 생성된 다리 리스트는 U와 D로만 구성되어야 한다.")
    @Test
    void madeBridgeContainsOnlyUAndDTest() {
        int bridgeSize = 7;
        List<String> madeBridge = bridgeMaker.makeBridge(bridgeSize);

        final String U = "U";
        final String D = "D";
        assertThat(madeBridge).containsOnly(U, D);
    }
}
