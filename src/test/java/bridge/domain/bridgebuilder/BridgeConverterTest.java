package bridge.domain.bridgebuilder;

import bridge.domain.resources.UpOrDown;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeConverterTest {

    @DisplayName("0은 D로, 1은 U로 잘 변환되는지 테스트")
    @Test
    void convertRandomNumToUDTest() {
        int input0 = 0;
        int input1 = 1;

        Assertions.assertThat(BridgeConverter.convertRandomNumToUD(input1)).isEqualTo(UpOrDown.UP);
        Assertions.assertThat(BridgeConverter.convertRandomNumToUD(input0)).isEqualTo(UpOrDown.DOWN);

    }

    @DisplayName("0과 1로 이루어진 List가 U와 D로 이루어진 List로 변환되는지 테스트")
    @Test
    void createRealBridgeTest() {
        List<Integer> input = List.of(1, 0, 0, 1, 1, 0, 1);
        List<String> result = List.of("U", "D", "D", "U", "U", "D", "U");

        Assertions.assertThat(BridgeConverter.createRealBridge(input)).isEqualTo(result);
    }
}