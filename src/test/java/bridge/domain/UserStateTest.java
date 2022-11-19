package bridge.domain;

import static org.assertj.core.api.Assertions.*;

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
}