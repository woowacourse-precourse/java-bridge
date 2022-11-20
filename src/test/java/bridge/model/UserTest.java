package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    public InputStream getPlayerInput(String input) {

        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @DisplayName("사용자 방향 입력")
    @ValueSource(strings = {"U"})
    void userCommandTest(String input) {
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        User user = new User();
        user.addUserCommand();
        Assertions.assertThat(user.getUserCommand().get(0)).isEqualTo(input);
    }

    @ParameterizedTest
    @DisplayName("사용자 입력 초기화")
    @ValueSource(strings = {"U"})
    void cleanCommandTest(String input) {
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        User user = new User();
        user.addUserCommand();
        user.cleanUserCommand();
        Assertions.assertThat(user.getUserCommand().isEmpty()).isEqualTo(true);
    }

}