package bridge.domain.bridge;

import bridge.domain.bridge.BridgeMaker;
import bridge.support.FakeBridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.support.ErrorMessage.BRIDGE_MAKER_SIZE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeMakerTest {

    BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        bridgeMaker = new BridgeMaker(new FakeBridgeNumberGenerator(List.of(0, 1, 0)));
    }

    @Test
    void DUDUDU리스트를_리턴한다() {
        //given
        int size = 6;
        List<String> expect = List.of("D", "U", "D", "U", "D", "U");

        //when
        List<String> res = bridgeMaker.makeBridge(size);

        //then
        assertThat(res).isEqualTo(expect);
    }

    @Test
    void 다리_길이가_3_20_사이의_값이_아닐_경우_예외가_발생한다() {
        //given
        int size = 2;

        //when then
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BRIDGE_MAKER_SIZE_ERROR);
    }
}