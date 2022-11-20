package bridge.domain;

import bridge.BridgeMaker;
import bridge.TestNumberGenerator;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {
    private static BridgeGame bridgeGame;
    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void initializeBridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));
        bridgeGame = new BridgeGame(bridge, new Player());
    }

    @DisplayName("칸 이동 로직 테스트")
    @Nested
    class MoveTest {
        @DisplayName("이동한 칸에 발판이 있다면 산다")
        @Test
        void moveToSafeSpace() {
            bridgeGame.move("U");
            assertThat(bridgeGame.isFailed()).isFalse();
        }

        @DisplayName("이동한 칸에 발판이 없으면 죽는다")
        @Test
        void moveToDangerSpace() {
            bridgeGame.move("D");
            assertThat(bridgeGame.isFailed()).isTrue();
        }

        @DisplayName("이동할 칸으로 이상한 값이 들어오면 예외처리한다")
        @ParameterizedTest
        @ValueSource(strings = {"X", "u", "d", " ", "", "1", "up", "down"})
        void moveToUnknownSpace(String spaceToMove) {
            assertThatThrownBy(() -> bridgeGame.move(spaceToMove))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

    @DisplayName("안 떨어지고 끝까지 도착하면 잘 종료된다")
    @Test
    void moveEnd() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.isFinished()).isTrue();
    }

    @DisplayName("이미 떨어졌는데 이동하려 하면 예외 처리한다")
    @Test
    void moveByDead() {
        bridgeGame.move("D");
        assertThatThrownBy(() -> bridgeGame.move("D"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
