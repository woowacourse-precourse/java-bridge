package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    @DisplayName("스코어 저장하기")
    void saveScore() {
        Score score = new Score();

        List<String> commands = new ArrayList<>(List.of("U", "D", "D"));
        for (String command : commands) {
            score.addGameResult(command);
        }
        Assertions.assertThat(score.getScoreBoard()).isEqualTo(new ArrayList<>(List.of("U", "D", "D")));
    }
}