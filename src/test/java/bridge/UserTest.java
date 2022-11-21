package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    void userSuccessTest() {
        User user = new User(List.of("U","D","U"),3);
        assertThat(user.isSuccess(3)).isEqualTo(false);
    }
}
