package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoveResultJudgementTest {
    private MoveResultJudgement moveResultJudgement;
    private String moving = "D";
    private final List<String> bridge = List.of("U", "D", "D");

    @BeforeEach
    void setUp() {
        moveResultJudgement = new MoveResultJudgement(bridge);
    }

    @ParameterizedTest
    @DisplayName("움직임이_성공했는지_반환")
    @CsvSource(value = {"0:false", "1:true", "2:true"}, delimiter = ':')
    void move_result(int currentDistance, boolean result) {
        assertThat(moveResultJudgement.movedResult(moving, currentDistance))
                .isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("게임이_완료_되었는지_확인")
    @CsvSource(value = {"0:false", "1:false", "2:true"}, delimiter = ':')
    void is_game_complete(int currentDistance, boolean result) {
        assertThat(moveResultJudgement.isGameComplete(moving, currentDistance))
                .isEqualTo(result);
    }

}