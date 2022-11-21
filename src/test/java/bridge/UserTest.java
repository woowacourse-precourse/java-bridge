package bridge;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @Test
    void userSuccessTest() {
        User user = new User(List.of("D","D","D"),3);
        assertThat(user.isSuccess(3)).isEqualTo(false);

        for (int i = 0; i < 3; i++)
            user.userMove("D");
        assertThat(user.isSuccess(3)).isEqualTo(true);
    }
}
