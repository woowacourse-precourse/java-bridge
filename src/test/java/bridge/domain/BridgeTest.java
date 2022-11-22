package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import exception.ExceptionMessage;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @DisplayName("문자열 배열을 기반으로 다리 객체를 생성합니다.")
    @Test
    void 다리_생성_성공() {
        List<String> originalBridge = Arrays.asList("U","D","D");
        List<String> testBridge = Arrays.asList("D","D","D");
        Bridge bridge = new Bridge(originalBridge);

        assertThat(bridge.isSame(originalBridge)).isEqualTo(true);
        assertThat(bridge.isSame(testBridge)).isEqualTo(false);
    }

}