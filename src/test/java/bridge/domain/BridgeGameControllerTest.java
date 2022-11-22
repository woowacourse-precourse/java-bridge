package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.command.BridgeSizeCommand;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("BridgeGameController 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeGameControllerTest {
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = mock(InputView.class);
        when(inputView.readBridgeSize()).thenReturn(new BridgeSizeCommand("3"));
    }

    @Test
    void 생성시_null_이_안_들어오면_잘_생성된다() {
        assertDoesNotThrow(() -> new BridgeGameController(inputView, outputView, bridgeMaker));
    }

    @Test
    void 생성시_inputView_에_null_이_들어오면_예외_발생() {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BridgeGameController(null, outputView, bridgeMaker));
            new BridgeGameController(null, outputView, bridgeMaker);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("inputView 에는 null 이 올 수 없습니다");
        }
    }

    @Test
    void 생성시_outputView_에_null_이_들어오면_예외_발생() {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BridgeGameController(inputView, null, bridgeMaker));
            new BridgeGameController(inputView, null, bridgeMaker);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("outputView 에는 null 이 올 수 없습니다");
        }
    }

    @Test
    void 생성시_bridgeMaker_에_null_이_들어오면_예외_발생() {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BridgeGameController(inputView, outputView, null));
            new BridgeGameController(inputView, outputView, null);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("bridgeMaker 에는 null 이 올 수 없습니다");
        }
    }
}
