package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    @Test
    @DisplayName("gameClear 호출 전 isGameClear 값이 false인지")
    void getIsGameClearBeforeGameClear() throws Exception {
        //given
        GameResult gameResult = new GameResult();
        boolean expect = false;
        //when
        boolean result = gameResult.getGameClear();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("gameClear 호출 후 isGameClear 값이 true로 변경되는지 확인")
    void getIsGameClearAfterGameClear() throws Exception {
        //given
        GameResult gameResult = new GameResult();
        boolean expect = true;
        //when
        gameResult.gameClear();
        boolean result = gameResult.getGameClear();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("attempt 3번 호출 후 tryCount 값이 같이 변하는가")
    void getTryCountAfterCallAttempt3Times() throws Exception {
        //given
        GameResult gameResult = new GameResult();
        int expect = 3;
        //when
        gameResult.attempt();
        gameResult.attempt();
        gameResult.attempt();

        int result = gameResult.getTryCount();
        //then
        assertThat(result).isEqualTo(expect);
    }
}