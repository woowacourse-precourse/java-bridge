package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bridge.domain.Bridge;
import bridge.exception.ErrorCode;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMakerInf bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @Test
    public void makeBridgeInvalidSizeFailure() {
        //given
        int size = 0;

        //when
        //then
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> bridgeMaker.makeBridge(size)
        );
        assertThat(exception.getMessage()).isEqualTo(ErrorCode.INVALID_SIZE.getMessage());
    }

    @Test
    public void makeBridgeSuccess() {
        //given
        int size = 20;

        //when
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));

        //then
        assertThat(bridge.getSequence().size()).isEqualTo(20);
    }
}