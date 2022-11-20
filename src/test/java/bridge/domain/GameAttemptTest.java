package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameAttemptTest {

    private GameAttempt gameAttempt = new GameAttempt();

    @DisplayName("게임을 5번 시도하면 게임 시도 횟수는 5번이다.")
    @Test
    void playGame5Times() {

        for(int play = 1; play <= 5; play++){
            gameAttempt.plusAttempt();
        }

        assertThat(gameAttempt.getAttempt()).isEqualTo(5);
    }

}