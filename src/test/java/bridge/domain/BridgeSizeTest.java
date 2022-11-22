package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BridgeSizeTest {
    @Test
    void 다리_길이_입력_3보다_작은_경우_오류_테스트(){
        //given
        int size = 1;
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Bridge(size)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_길이_입력_20보다_큰_경우_오류_테스트(){
        //given
        int size = 21;
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Bridge(size)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_길이_입력_범위_만족_경우_테스트(){
        //given
        int size = 3;
        //when
        Bridge bridge = new Bridge(size);
        //then
        Assertions.assertThat(bridge.getBridgeSize()).isEqualTo(3);
    }
}
