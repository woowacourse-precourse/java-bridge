package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayStateTest {

    @Test
    @DisplayName("게임 진행 상황 확인")
    void createState() {
        PlayState actualTrue = new PlayState(true);
        PlayState actualFalse = new PlayState(false);

        assertThat(actualTrue).isEqualTo(new PlayState(true));
        assertThat(actualFalse).isEqualTo(new PlayState(false));
    }

    @ParameterizedTest
    @DisplayName("게임 종료 시 진행 상황 확인")
    @CsvSource(value = {
            "true",
            "false"
    })
    void checkEnd(boolean state) {
        PlayState actual = new PlayState(state);
        PlayState end = actual.end();

        assertThat(end.nowState()).isFalse();
    }
}
