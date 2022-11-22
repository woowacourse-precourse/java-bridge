package bridge.constant;

import static bridge.constant.GameState.END_FAIL;
import static bridge.constant.GameState.END_SUCCESS;
import static bridge.constant.GameState.PROCEEDING_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameStateTest {

    @Test
    void 게임결과_반환_성공() throws Exception {
        assertThat(END_SUCCESS.getResult()).isEqualTo("성공");
    }

    @Test
    void 게임종료_여부_반환_성공() throws Exception {
        assertThat(END_FAIL.isEnd()).isTrue();
    }

    @Test
    void 게임성공_여부_반환_성공() throws Exception {
        assertThat(PROCEEDING_SUCCESS.isNotFail()).isTrue();
    }

    @Test
    void 게임을_종료상태로_반환() throws Exception {
        GameState gameState = GameState.toEnd(PROCEEDING_SUCCESS);
        assertThat(gameState).isEqualTo(END_SUCCESS);
    }
}