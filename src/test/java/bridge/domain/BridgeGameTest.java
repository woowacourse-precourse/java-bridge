package bridge.domain;

import bridge.BridgeMaker;
import bridge.TestNumberGenerator;
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
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3), new Player());
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
}
