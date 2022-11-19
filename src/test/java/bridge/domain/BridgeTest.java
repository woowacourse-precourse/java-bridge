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
        List<String> list = List.of("U", "D", "D");

        // when
        Bridge bridge = new Bridge(list);

        // then
        assertThat(bridge.getBridge()).isEqualTo(list);
    }

    @DisplayName("nowIndex Getter, Setter 테스트")
    @Test
    public void nowIndexGetterAndSetterTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        int index = 3;

        // when
        bridge.setNowIndex(index);

        // then
        assertThat(bridge.getNowIndex()).isEqualTo(index);
    }

    @DisplayName("resetGame 테스트")
    @Test
    public void resetGameTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        bridge.setNowIndex(3);

        // when
        bridge.resetGame();

        // then
        assertThat(bridge.getNowIndex()).isEqualTo(1);
    }

    @DisplayName("nowIndexUpdate 테스트")
    @Test
    public void nowIndexUpdateTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        // when
        bridge.nowIndexUpdate();

        // then
        assertThat(bridge.getNowIndex()).isEqualTo(2);
    }

    @DisplayName("getBridgeSize 테스트")
    @Test
    public void getBridgeSizeTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        // when
        int result = bridge.getBridgeSize();

        // then
        assertThat(result).isEqualTo(3);
    }

}
