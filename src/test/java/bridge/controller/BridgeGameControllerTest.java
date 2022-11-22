package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BridgeGameControllerTest {
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private InputView inputView;

    @Test
    void InputView_Null_Exception() {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BridgeGameController(null, outputView, bridgeMaker));
            new BridgeGameController(null, outputView, bridgeMaker);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("null 이 올 수 없습니다");
        }
    }

    @Test
    void OutputView_Null_Exception() {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BridgeGameController(inputView, null, bridgeMaker));
            new BridgeGameController(inputView, null, bridgeMaker);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("null 이 올 수 없습니다");
        }
    }

    @Test
    void BridgeMaker_Null_Exception() {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BridgeGameController(inputView, outputView, null));
            new BridgeGameController(inputView, outputView, null);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("null 이 올 수 없습니다");
        }
    }
}