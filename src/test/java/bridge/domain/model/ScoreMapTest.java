package bridge.domain.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.domain.enums.Move;
import bridge.domain.enums.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreMapTest {
    private ScoreMap scoreMap = new ScoreMap();
    private Result result;
    private Move move;
    @BeforeEach
    void SETTING() {
        result = Result.SUCCESS;
        move = Move.U;
    }

    @Test
    @DisplayName("점수가 옳바르게 매겨지고 옳바른 형식대로 생성되는지 확인하는 테스트")
    void SCORE_ONE() {
        scoreMap.score(result, move);
        assertThat(scoreMap.toString()).contains("[ O ]", "[   ]");
    }

    @Test
    @DisplayName("점수가 옳바르게 매겨지고 옳바른 형식대로 생성되는지 확인하는 테스트")
    void SCORE_MANY() {
        scoreMap.score(result, move);
        scoreMap.score(result, move);
        scoreMap.score(result, move);
        assertThat(scoreMap.toString()).contains("[ O | O | O ]", "[   |   |   ]");
    }

}