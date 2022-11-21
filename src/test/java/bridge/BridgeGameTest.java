package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.Constant;
import bridge.constant.Direction;
import bridge.constant.GameCommand;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BridgeGameTest {
    private BridgeGame bridgeGame = new BridgeGame();
    private UserBridge userBridge = new UserBridge();

    @ParameterizedTest
    @MethodSource("parameterProvider")
    void 이동_테스트(Direction direction, Direction now, String result) {
        bridgeGame.move(userBridge, direction, now);
        if (Direction.isUp(now)) {
            assertThat(userBridge.getUpBridge().contains(result)).isTrue();
        }
        if (Direction.isDown(now)) {
            assertThat(userBridge.getDownBridge().contains(result)).isTrue();
        }
    }

    @Test
    void 재시작_테스트() {
        BridgeGameManager bridgeGameManager = new BridgeGameManager();
        int count = bridgeGameManager.getCount();
        bridgeGame.retry(bridgeGameManager, userBridge, GameCommand.R.name());

        assertThat(userBridge.getUpBridge().isEmpty()).isTrue();
        assertThat(userBridge.getDownBridge().isEmpty()).isTrue();
        assertThat(bridgeGameManager.getCount()).isEqualTo(count+1);
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(Direction.D, Direction.U, Constant.CROSS_FAIL),
                Arguments.arguments(Direction.D, Direction.D, Constant.CROSS),
                Arguments.arguments(Direction.U, Direction.U, Constant.CROSS),
                Arguments.arguments(Direction.U, Direction.D, Constant.CROSS_FAIL)
        );
    }
}
