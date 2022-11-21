package bridge;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    Player player;

    @BeforeEach
    void beforeEach() {
        player = new Player();
    }

    @DisplayName("최대 도전 횟수를 오버플로시 예외가 발생한다.")
    @Test
    void overTotalTry() {
        boolean result = false;
        long tryNumber = (Integer.MAX_VALUE + 1L);
        try {
            while (tryNumber != 0) {
                tryNumber--;
                player.initRetryPlayer();
            }
        } catch (IllegalArgumentException exception) {
            result = true;
        }
        assertThat(true).isEqualTo(result);
    }

    @DisplayName("isPlayerMove 함수가 true를 정상적으로 반환한다.")
    @Test
    void executeIsPlayerMoveToTrue() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        player.updateMoveInfo("U");
        player.updateMoveInfo("D");
        player.updateMoveInfo("U");
        assertThat(true).isEqualTo(player.isPlayerMove(bridge));
    }

    @DisplayName("isPlayerMove 함수가 false를 정상적으로 반환한다.")
    @Test
    void executeIsPlayerMoveToFalse() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        player.updateMoveInfo("U");
        player.updateMoveInfo("D");
        player.updateMoveInfo("U");
        assertThat(false).isEqualTo(player.isPlayerMove(bridge));
    }

    @DisplayName("isClearGame 함수가 true를 정상적으로 반환한다.")
    @Test
    void executeIsClearGameToTrue() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        player.updateMoveInfo("U");
        player.updateMoveInfo("D");
        player.updateMoveInfo("U");
        player.isPlayerMove(bridge);
        assertThat(true).isEqualTo(player.isClearGame(bridge));
    }

    @DisplayName("isClearGame 함수가 false를 정상적으로 반환한다.")
    @ParameterizedTest
    @CsvSource({"U, D, U, U, D, D"})
    void executeIsClearGameToFalse(String bridge1, String bridge2, String bridge3,
                                   String move1, String move2, String move3) {
        Bridge bridge = new Bridge(List.of(bridge1, bridge2, bridge3));
        player.updateMoveInfo(move1);
        player.updateMoveInfo(move2);
        player.updateMoveInfo(move3);
        player.isPlayerMove(bridge);
        assertThat(false).isEqualTo(player.isClearGame(bridge));
    }

    @DisplayName("isClearGame 함수가 false를 정상적으로 반환한다.")
    @ParameterizedTest
    @CsvSource({"U, D, U, U, D", "U, D, U, U, U"})
    void executeIsClearGameToFalseByMidway(String bridge1, String bridge2, String bridge3,
                                           String move1, String move2) {
        Bridge bridge = new Bridge(List.of(bridge1, bridge2, bridge3));
        player.updateMoveInfo(move1);
        player.updateMoveInfo(move2);
        player.isPlayerMove(bridge);
        assertThat(false).isEqualTo(player.isClearGame(bridge));
    }
}
