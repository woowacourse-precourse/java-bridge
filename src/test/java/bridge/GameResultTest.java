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

}