package bridge.domain;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeMaker;
import bridge.domain.bridge.Move;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.GameStatus;
import bridge.domain.game.GameProgress;
import bridge.support.FakeBridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.bridge.Move.DOWN;
import static bridge.domain.bridge.Move.UP;
import static bridge.domain.game.GameStatus.FAILED;
import static bridge.domain.game.GameStatus.PLAYING;
import static bridge.domain.game.GameStatus.SUCCESS;
import static bridge.support.ErrorMessage.TOO_MANY_ATTEMPTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        BridgeMaker bridgeMaker = new BridgeMaker(new FakeBridgeNumberGenerator(newArrayList(0, 1, 0)));
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
            String moving = DOWN.getCode();

            //when
            GameStatus status = bridgeGame.move(moving);

            //then
            assertThat(status).isEqualTo(PLAYING);
        }

        @Test
        void 떨어지는_경우_FAILED를_리턴한다() {
            //given
            String moving = UP.getCode();

            //when
            GameStatus status = bridgeGame.move(moving);

            //then
            assertThat(status).isEqualTo(FAILED);
        }

        @Test
        void 끝까지_이동하는_경우_SUCCESS를_리턴한다() {
            //given
            bridgeGame.move(DOWN.getCode());
            bridgeGame.move(UP.getCode());
            String moving = DOWN.getCode();


            //when
            GameStatus status = bridgeGame.move(moving);

            //then
            assertThat(status).isEqualTo(SUCCESS);
        }
    }

    @Nested
    @DisplayName("retry 테스트")
    class RetryTest {

        @Test
        void 재시작하면_시도_횟수가_올라가고_진행_상황을_초기화_하며_PLAYING을_리턴한다() {
            //given
            bridgeGame.move(DOWN.getCode());
            bridgeGame.move(UP.getCode());

            //when
            GameStatus status = bridgeGame.retry();

            //then
            assertThat(status).isEqualTo(PLAYING);
            assertThat(bridgeGame.getAttempt()).isEqualTo(2);
            assertThat(bridgeGame.getGameProgress()).isEqualTo(new ArrayList<GameProgress>());
        }

        @Test
        void 너무_많은_시도를_하면_예외가_발생한다() {
            //given
            for (int i = 0; i < Integer.MAX_VALUE - 1; i++) {
                bridgeGame.retry();
            }

            //when then
            assertThatThrownBy(() -> bridgeGame.retry())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(TOO_MANY_ATTEMPTS);
        }
    }
}