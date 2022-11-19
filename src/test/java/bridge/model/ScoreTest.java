package bridge.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScoreTest {

    private Score score;

    @BeforeEach
    void setUp(){
        score = new Score();
    }

    @DisplayName("유저가 선택한 다리로 지나갈 수 있다.")
    @ParameterizedTest
    @CsvSource({"U, UDD", "D, DDD"})
    void canGo(String userStep, String bridge) {
        assertThat(score.goOneStep(new Bridge(List.of(bridge.split(""))), userStep)).isTrue();
    }

    @DisplayName("유저가 선택한 다리로 지나갈 수 없다..")
    @ParameterizedTest
    @CsvSource({"D, UDD", "U, DDD"})
    void canNotGo(String userStep, String bridge) {
        assertThat(score.goOneStep(new Bridge(List.of(bridge.split(""))), userStep)).isFalse();
    }

}