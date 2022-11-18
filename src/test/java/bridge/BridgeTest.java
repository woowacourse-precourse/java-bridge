package bridge;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeTest {
    @Test
    public void matchBlockLocation_리스트_범위_내에서_검색() throws Exception {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        //when
        boolean result = bridge.matchBlockLocation(1, "D");

        //then
        assertThat(result).isEqualTo(true);
    }
}