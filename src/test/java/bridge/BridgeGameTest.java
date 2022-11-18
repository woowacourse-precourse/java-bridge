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
        assertThat(bridgeGame.isPlayerAlive()).isEqualTo(expected);
    }

    @DisplayName("플레이어가 재시작에 동의하면 플레이어는 부활하고 위치가 0 이된다.")
    @Test
    void bridgeGameRetryTest() {
        //given
        bridgeGame.move("D");
        assertFalse(bridgeGame.isPlayerAlive());

        //when
        bridgeGame.retry();

        //then
        assertTrue(bridgeGame.isPlayerAlive());
        assertEquals(0,bridgeGame.getPlayer().getPosition());
    }

}
