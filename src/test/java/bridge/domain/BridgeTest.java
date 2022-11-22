package bridge.domain;

import bridge.domain.Bridge;
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

    @Test
    public void hasNextBlock_메서드로_남은_다리_블록_있는_경우() throws Exception {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        int playerLocation = 1;

        assertThat(bridge.hasNextBlock(playerLocation)).isTrue();
    }

    @Test
    public void hasNextBlock_메서드로_다리_끝에_있는_경우() throws Exception {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        int playerLocation = 2;

        assertThat(bridge.hasNextBlock(playerLocation)).isFalse();
    }
}