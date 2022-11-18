package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @DisplayName("생성자 및 getter 테스트")
    @Test
    public void BridgeConstructorAndGetterTest() {
        // given
        List<Integer> list = List.of(1, 0, 0);

        // when
        Bridge bridge = new Bridge(list);

        // then
        assertThat(bridge.getBridge()).isEqualTo(list);
    }
}
