package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("처음 생성된 플레이어의 시도 횟수는 1이다.")
    @Test
    void initAttempt() {
        //given
        Player player = new Player();

        //when
        int attempt = player.getAttempt();

        //then
        assertThat(attempt).isEqualTo(1);
    }

    @DisplayName("플레이어의 시도 횟수가 증가한다.")
    @Test
    void increaseAttempt() {
        //given
        Player player = new Player();

        //when
        player.attempt();
        int attempt = player.getAttempt();

        //then
        assertThat(attempt).isEqualTo(2);
    }

}