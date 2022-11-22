package bridge.domain.bridgegame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserChoiceTest {
    @Test
    void 유저_선택_타입_반환_테스트() {
        assertThat(UserChoice.findGame(true, true)).isEqualTo(UserChoice.PASS);
        assertThat(UserChoice.findGame(true, false)).isEqualTo(UserChoice.FAIL);
        assertThat(UserChoice.findGame(false, true)).isEqualTo(UserChoice.NONE);
        assertThat(UserChoice.findGame(false, false)).isEqualTo(UserChoice.NONE);
    }

}