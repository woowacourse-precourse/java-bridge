package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.model.BridgeMaker;
import bridge.model.Direction;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("주어진 길이 만큼의 랜덤한 리스트를 생성")
    @Test
    void makeBridgeSuccess() {
        // given
        int length = 10;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final String u = Direction.U.toString();
        final String d = Direction.D.toString();

        // when
        List<String> bridge = bridgeMaker.makeBridge(length);

        // then
        assertThat(bridge.size()).isEqualTo(length);
        bridge.forEach(dir -> {
            assertThat(dir).isIn(u, d);
        });
    }

    @DisplayName("주어진 길이가 범위를 벗어나면 예외를 일으킨다")
    @Test
    void makeBridgeFail() {
        // given
        List<Integer> lengths = List.of(2, 21);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // then
        lengths.forEach(i -> {
            assertThatThrownBy(() -> bridgeMaker.makeBridge(i))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }
}