package bridge.service;

import bridge.constant.ViewStatus;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeServiceTest {

    private final BridgeService bridgeService = new BridgeService();

    @ValueSource(ints = {21,40,-1})
    @ParameterizedTest
    void throwErrorWhenSizeIsInvalid(int size) {
        assertThatThrownBy(() ->
                bridgeService.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(ints = {20,3,5})
    @ParameterizedTest
    void returnMakeBridgeResponseWhenSizeIsInvalid(int size) {
        assertThat(bridgeService.makeBridge(size))
                .isEqualTo(ViewStatus.DETERMINE_MOVE);
    }
}