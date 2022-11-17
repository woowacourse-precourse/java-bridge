package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("정해진 범위보다 짧은 길이를 입력하면 예외가 발생한다.")
    @Test
    void outOfStartRange() {
        //given
        int size = -1;

        //then
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정해진 범위보다 긴 길이를 입력하면 예외가 발생한다.")
    @Test
    void outOfEndRange() {
        //given
        int size = 21;

        //then
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("알맞은 길이를 입력하면 해당 길이의 다리를 생성한다.")
    @Test
    void makeBridge() {
        //given
        int size = 10;

        //when
        List<String> bridges = bridgeMaker.makeBridge(size);

        //then
        assertThat(bridges).isNotEmpty();
        assertThat(bridges.size()).isEqualTo(size);
    }

}