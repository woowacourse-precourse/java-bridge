package bridge.view.constant;

import static bridge.view.constant.OutputMessage.GAME_RESULT_MAIN_PHRASE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OutputMessageTest {

    @Test
    void 콘솔_메시지_출력성공() throws Exception {
        assertThat(GAME_RESULT_MAIN_PHRASE.getMessage()).isEqualTo("최종 게임 결과");
    }

}