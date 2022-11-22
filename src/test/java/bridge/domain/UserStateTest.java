package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserStateTest {
    @DisplayName("다리를 한 칸 건너는 기능")
    @Test
    public void 다리_한_칸_건너기() {
        UserState userState = new UserState();
        userState.moveToUp("O");
        userState.moveToDown("O");
        userState.moveToUp("X");
        assertThat(userState.toString()).isEqualTo("[ O |   | X ]\n[   | O |   ]");
    }

    @DisplayName("다리를 다 건넜는지 여부를 알려주는 기능")
    @Test
    public void 다리_건너기_성공_여부() {
        UserState userState = new UserState();
        userState.moveToUp("O");
        userState.moveToDown("O");
        userState.moveToUp("O");
        assertThat(userState.isSuccessOrFail(3)).isTrue();

        assertThat(userState.isSuccessOrFail(4)).isFalse();

        userState.moveToUp("X");
        assertThat(userState.isSuccessOrFail(4)).isFalse();
    }
}