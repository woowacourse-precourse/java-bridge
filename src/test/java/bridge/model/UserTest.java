package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    public InputStream getPlayerInput(String input) {

        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("사용자 방향 입력")
    void userCommandTest() {
        User user = new User();
        Assertions.assertThat(user.addUserCommand("U")).isEqualTo(new ArrayList<>(List.of("U")));
    }

    @Test
    @DisplayName("사용자 입력 초기화")
    void cleanCommandTest() {
        User user = new User();
        user.addUserCommand("U");
        Assertions.assertThat(user.cleanUserCommand()).isEmpty();

    }

}