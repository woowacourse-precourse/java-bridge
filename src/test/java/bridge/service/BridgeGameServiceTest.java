package bridge.service;

import bridge.domain.Command;
import bridge.domain.game.GameStatus;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeMaker;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.GameProgress;
import bridge.dto.MapDto;
import bridge.dto.ResultDto;
import bridge.support.FakeBridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static bridge.domain.Command.QUIT;
import static bridge.domain.Command.RETRY;
import static bridge.domain.game.GameStatus.FAILED;
import static bridge.domain.game.GameStatus.PLAYING;
import static bridge.domain.game.GameStatus.SUCCESS;
import static bridge.domain.Move.DOWN;
import static bridge.domain.Move.UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
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
    }

    @Nested
    @DisplayName("executeIfRetry 테스트")
    class ExecuteIfRetry {

        @Test
        void 재시작_커맨드가_들어오면_시도_횟수가_올라가고_진행_상황이_초기화가_되며_true를_리턴한다() {
            //given
            GameProgress expect = new GameProgress();
            Command command = RETRY;

            //when
            boolean res = service.executeIfRetry(command);

            //then
            assertThat(res).isTrue();
            assertThat(bridgeGame.getAttempt()).isEqualTo(2);
            assertThat(bridgeGame.getGameProgress())
                    .usingRecursiveComparison()
                    .isEqualTo(expect);
        }

        @Test
        void 재시작_외의_커맨드가_들어오면_false를_리턴한다() {
            //given
            Command command = QUIT;

            //when
            boolean res = service.executeIfRetry(command);

            //then
            assertThat(res).isFalse();
        }
    }

    @Order(2)
    @ParameterizedTest
    @CsvSource(value = {"D, ,O", "U,X, "}, ignoreLeadingAndTrailingWhitespace = false)
    void getMapDto_한_칸_이동의_결과를_담은_dto를_리턴한다(String move, String upside, String downSide) {
        //given
        MapDto expect = new MapDto(String.format("[ %s ]\n[ %s ]", upside, downSide));
        bridgeGame.move(move);

        //when
        MapDto res = service.getMapDto();

        //then
        assertThat(res).usingRecursiveComparison()
                .isEqualTo(expect);
    }

    @Test
    @Order(3)
    void getResultDto_게임_결과에_관한_정보를_담은_dto를_리턴한다() {
        //given
        GameStatus status = FAILED;
        ResultDto expect = new ResultDto(status, 1, service.getMapDto());

        //when
        ResultDto resultDto = service.getResultDto(status);

        //then
        assertThat(resultDto).usingRecursiveComparison()
                .isEqualTo(expect);
    }
}