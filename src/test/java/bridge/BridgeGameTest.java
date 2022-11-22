package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();
    private static Player player;

    @BeforeEach
    void setUp() {
        player = new Player(List.of("U", "D", "U"));
    }

    @DisplayName("이동 결과를 확인하는 테스트")
    @ParameterizedTest
    @CsvSource({"U,true", "D,false"})
    void move(String direction, boolean expected) {
        boolean actual = bridgeGame.move(player, direction);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("재시작을 하면 게임 횟수는 증가")
    @Test
    void retryByPlayCount() {
        player.addDirection("D");

        bridgeGame.retry(player);

        assertThat(player.getPlayCount()).isEqualTo(2);
    }

    @DisplayName("재시작을 하면 방향 정보는 비워짐")
    @Test
    void retryByDirections() {
        player.addDirection("D");

        bridgeGame.retry(player);

        assertThat(player.getDirections()).isEmpty();
    }
}