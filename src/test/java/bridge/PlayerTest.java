package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private static final Player player = new Player(List.of("U", "D", "U"));

    @BeforeEach
    void setUp() {
        addResult();
    }

    @DisplayName("다리의 크기과 결과의 크기가 같으면 게임 종료")
    @Test
    void isGameEnd() {
        addResult();
        addResult();

        assertThat(player.isGameEnd()).isTrue();
    }

    @DisplayName("결과가 리셋되면 게임 횟수는 1만큼 증가")
    @Test
    void resetResultsPlayCount() {
        int previous = player.getPlayCount();

        player.resetDirections();

        assertThat(player.getPlayCount()).isEqualTo(previous + 1);
    }

    @DisplayName("결과가 리셋되면 결과는 비워짐")
    @Test
    void resetResultsSize() {
        player.resetDirections();

        assertThat(player.getDirections().size()).isEqualTo(0);
    }

    private void addResult() {
        player.addDirection("O");
    }
}