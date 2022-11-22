package bridge.domain;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoveResultJudgementTest {
    private MoveResultJudgement moveResultJudgement;
    private String moving = "D";
    private final List<String> bridge = List.of("U", "D", "D");

    @BeforeEach
    void setUp() {
        moveResultJudgement = new MoveResultJudgement(bridge);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true", "2:true"}, delimiter = ':')
    void move_result(int currentDistance, boolean result) {
        assertThat(moveResultJudgement.movedResult(moving, currentDistance))
                .isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:true"}, delimiter = ':')
    void is_game_complete(int currentDistance, boolean result) {
        assertThat(moveResultJudgement.isGameComplete(moving, currentDistance))
                .isEqualTo(result);
    }

}