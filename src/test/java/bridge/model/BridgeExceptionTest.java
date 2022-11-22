package bridge.model;

import bridge.view.ErrorView;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class BridgeExceptionTest {

    private Bridge bridge;
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;


    @BeforeEach
    void init() {
        bridge = Mockito.mock(Bridge.class);
        inputView = Mockito.mock(InputView.class);
        outputView = Mockito.mock(OutputView.class);
        bridgeMaker = Mockito.mock(BridgeMaker.class);

        when(bridgeMaker.makeBridge(3)).thenReturn(List.of("U", "D", "D"));
    }

    @DisplayName("다리 길이를 입력 시, 3 ~ 20 아니면 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"a", "2", "-1", "100"})
    void 다리_길이_유효성_검사(String bridgeLength) {
        assertThatThrownBy(() -> new BridgeException().invalidLengthInputValue(bridgeLength))
                .hasMessageContaining(ErrorView.error)
                .hasMessageContaining(ErrorView.INVALID_BRIDGE_LENGTH.getMessage())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 이동할 칸을 입력 시 U, D 아니면 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "123", "?"})
    void 이동_입력_값_유효성_검사(String movingDirection) {
        assertThatThrownBy(() -> new BridgeException().invalidMovingInputValue(movingDirection))
                .hasMessageContaining(ErrorView.error)
                .hasMessageContaining(ErrorView.INVALID_MOVING_DIRECTION.getMessage())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작/종료 여부를 입력 시, R, Q 아니면 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "-1213", "?!@"})
    void 게임_재시작_입력_값_유효성_검사(String gameCommand) {
        assertThatThrownBy(() -> new BridgeException().invalidRetryGame(gameCommand))
                .hasMessageContaining(ErrorView.error)
                .hasMessageContaining(ErrorView.INVALID_RETRY_GAME.getMessage())
                .isInstanceOf(IllegalArgumentException.class);
    }
}