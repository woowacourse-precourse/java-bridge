package bridge.domain;

import bridge.support.FakeBridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.domain.BridgeUnit.DOWN;
import static bridge.domain.BridgeUnit.UP;
import static bridge.domain.GameStatus.FAILED;
import static bridge.domain.GameStatus.PLAYING;
import static bridge.domain.GameStatus.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        BridgeMaker bridgeMaker = new BridgeMaker(new FakeBridgeNumberGenerator());
        List<String> rawBridge = bridgeMaker.makeBridge(3);
        Bridge bridge = new Bridge(rawBridge);
        bridgeGame = new BridgeGame(bridge);
    }

    @Nested
    @DisplayName("move 테스트")
    class MoveTest {

        @Test
        void 이동에_성공하는_경우_PLAYING을_리턴한다() {
            //given
            BridgeUnit nextUnit = DOWN;

            //when
            GameStatus status = bridgeGame.move(nextUnit);

            //then
            assertThat(status).isEqualTo(PLAYING);
        }

        @Test
        void 떨어지는_경우_FAILED를_리턴한다() {
            //given
            BridgeUnit nextUnit = UP;

            //when
            GameStatus status = bridgeGame.move(nextUnit);

            //then
            assertThat(status).isEqualTo(FAILED);
        }

        @Test
        void 끝까지_이동하는_경우_SUCCESS를_리턴한다() {
            //given
            bridgeGame.move(DOWN);
            bridgeGame.move(UP);

            //when
            GameStatus status = bridgeGame.move(DOWN);

            //then
            assertThat(status).isEqualTo(SUCCESS);
        }
    }
}