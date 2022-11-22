package bridge.exception;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameExceptionTest {
    private static final BridgeGameException bridgeGameException = new BridgeGameException();

    @ParameterizedTest
    @ValueSource(strings = {"-1","21","4j",""})
    @DisplayName("올바르지 않은 입력값")
    void 사용자_다리생성_입력_오류(String inputSize) {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> bridgeGameException.validateBridgeSize(inputSize))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @DisplayName("잘못된 입력을 받으면 예외 반환")
    @ValueSource(strings = {"x", "d", "d3"})
    @ParameterizedTest
    void 사용자_다리이동입력_오류(String inputShape) {
        assertThatThrownBy(() ->
                bridgeGameException.validateMovingCommand(inputShape))
                .isInstanceOf((IllegalArgumentException.class));

    }

    @DisplayName("다리 이동 잘못된 입력을 받으면 예외 반환")
    @ValueSource(strings = {"-", "r", "","R2"})
    @ParameterizedTest
    void 사용자_재시작_오류(String inputGameCommand) {
        assertThatThrownBy(() ->
                bridgeGameException.validateGameCommand(inputGameCommand))
                .isInstanceOf((IllegalArgumentException.class));

    }
}