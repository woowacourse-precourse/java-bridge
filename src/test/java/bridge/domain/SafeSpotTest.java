package bridge.domain;

import static bridge.util.Constant.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SafeSpotTest {

    @Test
    void 랜덤숫자_0이면_DOWN_반환() {
        String location = SafeSpot.locationOf(0);
        assertThat(location).isEqualTo(DOWNLOCATION);
    }

    @Test
    void 랜덤숫자_1이면_UP_반환() {
        String location = SafeSpot.locationOf(1);
        assertThat(location).isEqualTo(UPLOCATION);
    }

    @Test
    void 허용되지_않은_랜덤숫자_예외() {
        assertThatThrownBy(
            () -> SafeSpot.locationOf(2)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
