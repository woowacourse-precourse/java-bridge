package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @Test
    @DisplayName("이동 성공 테스트")
    void userSuccessTest() {
        User user = new User(List.of("D","D","D"),3);
        assertThat(user.isSuccess(3)).isEqualTo(false);

        for (int i = 0; i < 3; i++)
            user.userMove("D");
        assertThat(user.isSuccess(3)).isEqualTo(true);
    }
    @Test
    @DisplayName("이동 실패 테스트")
    void userFailureTest() {
        User user = new User(List.of("U","U","U"),3);
        user.userMove("U");
        assertThat(user.isFailure()).isEqualTo(false);

        user.userMove("D");
        assertThat(user.isFailure()).isEqualTo(true);
    }
}
