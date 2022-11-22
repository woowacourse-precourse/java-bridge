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

    @DisplayName("문자열 배열을 기반으로 다리 객체를 생성합니다.")
    @Test
    void 다리_생성_예외() {
        List<String> originalBridge = Arrays.asList("U","D","A");

        assertThatCode(() -> new Bridge(originalBridge))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DOES_NOT_EXIST_UP_DOWN);
    }

    @DisplayName("주어진 인덱스와 움직임이 같을 경우 성공 결과를 반환합니다.")
    @Test
    void 결과_반환_테스트_성공() {
        List<String> originalBridge = Arrays.asList("U","D","D");
        Bridge bridge = new Bridge(originalBridge);

        Result result1 = bridge.distinguish(0, Move.UP);

        assertThat(result1).isEqualTo(Result.SUCCESS);
    }

    @DisplayName("주어진 인덱스와 움직임이 다를 경우 실패 결과를 반환합니다.")
    @Test
    void 결과_반환_테스트_실패() {
        List<String> originalBridge = Arrays.asList("U","D","D");
        Bridge bridge = new Bridge(originalBridge);

        Result result1 = bridge.distinguish(0,Move.DOWN);

        assertThat(result1).isEqualTo(Result.FAIL);
    }

}