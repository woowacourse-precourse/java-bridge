package bridge;

import bridge.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
        for (int i = 0; i < expect; i++) {
            user.move();
        }

        assertThat(user.getMoveCount()).isEqualTo(expect);
    }

    @DisplayName("trial 카운트 테스트")
    @ParameterizedTest(name = "input = {0}")
    @CsvSource({"1, 2", "2, 3", "3, 4"})
    void checkTrialCountAfterRetry(int retryCount, String expect) {
        for (int i = 0; i < retryCount; i++) {
            user.retry();
        }

        assertThat(user.getTrial()).isEqualTo(expect);
    }
}
