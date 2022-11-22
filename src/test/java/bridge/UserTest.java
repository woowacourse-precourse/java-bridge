package bridge;

import bridge.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {
    User user;

    @BeforeEach
    void generateUser() {
        user = new User();
    }

    @DisplayName("moveCount 테스트")
    @ParameterizedTest(name = "input = {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void checkGetMoveCount(int expect) {
        for (int i = 0; i < expect; i++ ) {
            user.move();
        }

        assertThat(user.getMoveCount()).isEqualTo(expect);

    }
}
