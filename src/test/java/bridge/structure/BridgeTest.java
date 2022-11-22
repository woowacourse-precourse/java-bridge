package bridge.structure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    @Test
    void 다리_건널_수_있는지_판단_성공() throws Exception {
        //given
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        BridgeMoveValue up = BridgeMoveValue.UP;
        int turnCount = 1;

        //when
        boolean canGo = bridge.canGo(up, turnCount);

        //then
        Assertions.assertThat(canGo)
                .isTrue();
    }

    @Test
    void 다리_건널_수_있는지_판단_실패() throws Exception {
        //given
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        BridgeMoveValue down = BridgeMoveValue.DOWN;
        int turnCount = 1;

        //when
        boolean canGo = bridge.canGo(down, turnCount);

        //then
        Assertions.assertThat(canGo)
                .isFalse();
    }

    @Test
    void 다리게임_턴_검증() throws Exception {
        //given
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        BridgeMoveValue down = BridgeMoveValue.DOWN;
        int turnCount = 4;

        //when


        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() ->bridge.canGo(down, turnCount));

    }

}