package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.MoveResult;
import bridge.domain.Player;
import bridge.domain.Victory;
import bridge.dto.GameMoveDto;
import bridge.dto.GameResultDto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("BridgeGameService 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeGameServiceTest {

    private final BridgeNumberGenerator bridgeNumberGenerator = new TestBridgeNumberGenerator(
            newArrayList(0, 0, 1)
    );
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private BridgeGameService bridgeGameService;

    @BeforeEach
    void setup() {
        bridgeGameService = new BridgeGameService(bridgeMaker);
    }

    @Test
    void initializeBridgeGame_메서드는_다리_길이를_입력받아_BridgeGame을_초기화시킨다() {
        int givenSize = 3;

        bridgeGameService.initializeBridgeGame(givenSize);

        assertThat(bridgeGameService.isPlayable()).isTrue();
    }

    @Test
    void play_메서드는_사용자와_방향을_입력받아_다리를_건너고_결과를_반환한다() {
        bridgeGameService.initializeBridgeGame(3);

        GameMoveDto gameMoveDto = bridgeGameService.play(new Player(), "U");

        assertThat(gameMoveDto.getResult().get(0)).isEqualTo(List.of(MoveResult.FAIL));
    }

    @Test
    void play_메서드는_다리가_준비되지_않은경우_IllegalStateException을_던진다() {
        assertThatThrownBy(() -> bridgeGameService.play(new Player(), "U"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("다리 건너기 게임을 진행할 수 없습니다.");
    }

    @Test
    void isPlayable_메서드는_다리가_초기화되지_않은_경우_false를_반환한다() {
        boolean result = bridgeGameService.isPlayable();

        assertThat(result).isFalse();
    }

    @ParameterizedTest(name = "{0}을 입력받으면 재시작여부: {1}")
    @CsvSource({"R, true", "Q, false"})
    void retry_메서드는_command를_입력받아_게임을_재시작_설정을_한다(String command, boolean result) {
        bridgeGameService.initializeBridgeGame(3);
        Player player = new Player();
        bridgeGameService.play(player, "U");

        bridgeGameService.retry(player, command);

        assertThat(bridgeGameService.isPlayable()).isEqualTo(result);
    }

    @Test
    void retry_메서드는_다리가_초기화되지_않은_경우_게임을_재시작하지_않고_그대로_반환한다() {
        bridgeGameService.retry(new Player(), "R");

        assertThat(bridgeGameService.isPlayable()).isFalse();
    }

    @Test
    void isGameOver_메서드는_사용자가_다리건너기에_성공하면_true를_반환한다() {
        bridgeGameService.initializeBridgeGame(3);
        Player player = new Player();
        bridgeGameService.play(player, "D");
        bridgeGameService.play(player, "D");
        bridgeGameService.play(player, "U");

        assertThat(bridgeGameService.isGameOver(player)).isTrue();
    }

    @Test
    void gameOver_메서드는_사용자를_입력받아_GameResultDto를_반환한다() {
        bridgeGameService.initializeBridgeGame(3);
        Player player = new Player();
        bridgeGameService.play(player, "D");
        bridgeGameService.play(player, "D");
        bridgeGameService.play(player, "U");

        GameResultDto gameResultDto = bridgeGameService.gameOver(player);

        assertThat(gameResultDto.getCount()).isEqualTo(1);
        assertThat(gameResultDto.getVictory()).isEqualTo(Victory.VICTORY);
        assertThat(gameResultDto.getGameMoveDto()).isInstanceOf(GameMoveDto.class);
    }

    static class TestBridgeNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestBridgeNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
