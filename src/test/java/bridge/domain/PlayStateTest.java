package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayStateTest {

    @ParameterizedTest
    @DisplayName("게임 진행 상황 확인")
    @CsvSource(value = {
            "true,true",
            "false,false"
    })
    void createState(boolean state, boolean expected) {
        PlayState actual = new PlayState(state);
        actual.nowState();

        assertThat(actual.nowState()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("게임 종료 시 진행 상황 확인")
    @CsvSource(value = {
            "true",
            "false"
    })
    void checkEnd(boolean state) {
        PlayState actual = new PlayState(state);
        actual.end();

        assertThat(actual.nowState()).isFalse();
    }
}
