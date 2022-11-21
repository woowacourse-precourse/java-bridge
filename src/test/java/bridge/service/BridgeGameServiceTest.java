package bridge.service;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeMaker;
import bridge.domain.bridge.Move;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.GameStatus;
import bridge.support.FakeBridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.domain.bridge.Move.DOWN;
import static bridge.domain.bridge.Move.UP;
import static bridge.domain.game.GameStatus.FAILED;
import static bridge.domain.game.GameStatus.PLAYING;
import static bridge.domain.game.GameStatus.SUCCESS;
import static bridge.support.ErrorMessage.INVALID_COMMAND_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameServiceTest {

    BridgeGame bridgeGame;
    BridgeGameService service;

    @BeforeEach
    void init() {
        BridgeMaker bridgeMaker = new BridgeMaker(new FakeBridgeNumberGenerator(newArrayList(0, 1, 0)));
        List<String> rawBridge = bridgeMaker.makeBridge(3);
        Bridge bridge = new Bridge(rawBridge);
        bridgeGame = new BridgeGame(bridge);
        service = new BridgeGameService(bridgeGame);
    }

    @Nested
    @DisplayName("crossBridgeUnit 테스트")
    class CrossMoveTest {

        @Test
        void 다음_다리를_건너는데_성공하면_PLAYING을_리턴한다() {
            //given
            String moving = "D";

            //when
            GameStatus status = service.crossBridgeUnit(moving);

            //then
            assertThat(status).isEqualTo(PLAYING);
        }

        @Test
        void 다음_다리를_건너는데_실패하면_FAILED을_리턴한다() {
            //given
            String moving = "U";

            //when
            GameStatus status = service.crossBridgeUnit(moving);

            //then
            assertThat(status).isEqualTo(FAILED);
        }

        @Test
        void 다리를_끝까지_건너는데_성공하면_PLAYING을_리턴한다() {
            //given
            bridgeGame.move(DOWN.getCode());
            bridgeGame.move(UP.getCode());
            String moving = "D";

            //when
            GameStatus status = service.crossBridgeUnit(moving);

            //then
            assertThat(status).isEqualTo(SUCCESS);
        }

        @Test
        void U_D_이외의_값이_넘어오면_예외가_발생한다() {
            //given
            String moving = "A";

            //when then
            assertThatThrownBy(() -> service.crossBridgeUnit(moving))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_COMMAND_ERROR);
        }
    }

    @Nested
    @DisplayName("executeGameCommand 테스트")
    class ExecuteGameCommand {

        @Test
        void 재시작_커맨드가_들어오면_시도_횟수가_올라가고_진행_상황이_초기화된다() {
            //given
            String command = "R";

            //when
            GameStatus status = service.executeGameCommand(command);

            //then
            assertThat(status).isEqualTo(PLAYING);
            assertThat(bridgeGame.getAttempt()).isEqualTo(2);
            assertThat(bridgeGame.getGameProgress()).isEqualTo(List.of());
        }
    }


    @Test
    void getResultDto() {
    }

    @Test
    void getMapDto() {
    }
}