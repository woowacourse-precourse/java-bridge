package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.enums.Command;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserStateTest {
    @DisplayName("다리를 한 칸 건너는 기능")
    @Test
    public void 다리_한_칸_건너기() {
        UserState userState = new UserState();
        userState.moveToNext(true, Command.UP.getCommand());
        userState.moveToNext(true, Command.DOWN.getCommand());
        userState.moveToNext(false, Command.UP.getCommand());
        assertThat(userState.toString()).isEqualTo("[ O |   | X ]\n[   | O |   ]");
    }

    @DisplayName("다리를 다 건넜는지 여부를 알려주는 기능")
    @Test
    public void 다리_건너기_성공_여부() {
        UserState userState = new UserState();
        userState.moveToNext(true, Command.UP.getCommand());
        userState.moveToNext(true, Command.DOWN.getCommand());
        userState.moveToNext(true, Command.UP.getCommand());
        assertThat(userState.isSuccessOrFail(3)).isTrue();

        assertThat(userState.isSuccessOrFail(4)).isFalse();

        userState.moveToNext(false, Command.UP.getCommand());
        assertThat(userState.isSuccessOrFail(4)).isFalse();
    }
}