package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("다리 값과 입력값을 비교하는 메서드 검증")
class BridgeTest {

    @Test
    void 다리_값과_입력값이_같은_경우() {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D"));
        Assertions.assertThat(bridge.isMatch(0, Direction.UP)).isEqualTo(true);
    }

    @Test
    void 다리_값과_입력값이_다른_경우() {
        Bridge bridge = new Bridge(List.of("U", "U", "U", "U"));
        Assertions.assertThat(bridge.isMatch(0, Direction.DOWN)).isEqualTo(false);
    }
}