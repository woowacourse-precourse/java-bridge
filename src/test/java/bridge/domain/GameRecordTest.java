package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.game.GameRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameRecordTest {
    private GameRecord gameRecord;

    @BeforeEach
    void setUp() {
        this.gameRecord = new GameRecord();
    }

    @Test
    void 횟수_증가_테스트() {
        int expected = gameRecord.getRetryCount() + 1;

        gameRecord.incrementRetryCount();
        int actual = gameRecord.getRetryCount();

        assertThat(actual).isEqualTo(expected);
    }

}