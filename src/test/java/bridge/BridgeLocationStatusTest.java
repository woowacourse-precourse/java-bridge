package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeLocationStatusTest {

    @Test
    void enum_값의_상수를_비교해서_값이_존재하면_그에_맞는_enum_객체_생성() {
        //when
        BridgeLocationStatus upStatus = BridgeLocationStatus.getBridgeLocationStatus("U");
        BridgeLocationStatus downStatus = BridgeLocationStatus.getBridgeLocationStatus("D");

        //then
        assertAll(
                () -> Assertions.assertThat(upStatus).isEqualTo(BridgeLocationStatus.UP),
                () -> Assertions.assertThat(downStatus).isEqualTo(BridgeLocationStatus.DOWN)
        );
    }

    @Test
    void enum_값의_상수를_비교해서_값이_존재하지_않으면_IllegalArgumentException_발생() {
        //then
        Assertions.assertThatThrownBy(() -> {
            BridgeLocationStatus.getBridgeLocationStatus("R");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void enum_객체의_상수값이_맞는지_안_맞는지_결과값_도출() {
        //given
        BridgeLocationStatus up = BridgeLocationStatus.UP;

        //when
        boolean result = up.compareBridge("U");

        //then
        Assertions.assertThat(result).isTrue();
    }
}
