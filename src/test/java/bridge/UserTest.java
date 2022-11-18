package bridge;

import bridge.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {
    User user;

    @BeforeEach
    void generateUser() {
        user = new User();
    }

    @DisplayName("moveCount 테스트")
    @Test
    void checkGetMoveCount() {
        List<String> moveInputs = List.of("D","U","D","U","D","U");

        for (String moveInput : moveInputs) {
            user.move(moveInput);
        }

        assertThat(user.getMoveCount()).isEqualTo(moveInputs.size());

    }
}
