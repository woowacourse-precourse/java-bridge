package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        int size = 3;
        BridgeNumberGenerator bridgeNumberGenerator = new ManualNumberGenerator(
            newArrayList(1, 0, 0));
        bridgeGame = new BridgeGame(size, bridgeNumberGenerator);
    }

    @Test
    void 다리_생성_검증_테스트() {
        assertThat(bridgeGame.getBridge()).containsExactly("U", "D", "D");
    }

    @DisplayName("이동할수 없는 칸이면 Player 는 사망한다.")
    @ParameterizedTest
    @CsvSource({
        "U, true",
        "D, false",
    })
    void bridgeGameMoveTest(String playerChoice, boolean expected) {
        bridgeGame.move(playerChoice);
        assertEquals(expected, bridgeGame.isPlayerAlive());
    }

    @DisplayName("플레이어가 재시작에 동의하면 플레이어는 부활하고 위치가 0 이된다.")
    @Test
    void bridgeGameRetryTest() {
        //given
        bridgeGame.move("D");
        assertFalse(bridgeGame.isPlayerAlive());

        //when
        bridgeGame.retry("R");

        //then
        assertTrue(bridgeGame.isPlayerAlive());
        assertEquals(0, bridgeGame.getPlayer().getPosition());
    }

    @DisplayName("플레이어가 죽거나 마지막 스테이지를 통과하면 게임은 종료 된다.")
    @ParameterizedTest
    @CsvSource({
        "U,D,D,true,true",
        "U,D,U,true,false"
    })
    void isGameEndTest(String stage1, String stage2, String stage3, boolean isGameEnd,
        boolean isPlayerAlive) {
        //when
        bridgeGame.move(stage1);
        bridgeGame.nextRound();

        bridgeGame.move(stage2);
        bridgeGame.nextRound();

        bridgeGame.move(stage3);
        bridgeGame.nextRound();
        //then
        assertEquals(isPlayerAlive, bridgeGame.isPlayerAlive());
        assertEquals(isGameEnd, bridgeGame.isGameEnd());
    }

    @DisplayName("플레이어가 재시작에 동의하면 도전횟수가 1 증가한다.")
    @Test
    void bridgeGameTrialCountTest() {
        //given
        bridgeGame.move("D");
        assertEquals(1, bridgeGame.getTrialCount());

        //when
        bridgeGame.retry("R");

        //then
        assertEquals(2, bridgeGame.getTrialCount());

    }

}
