package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @ParameterizedTest
    @DisplayName("인덱스의 범위를 초과하면 예외가 발생해야 한다.")
    @ValueSource(ints = {-1, 3})
    void getIndexOfByIllegalIndex(int index) {
        // given
        user.move(UpDownFlag.UP);
        user.move(UpDownFlag.UP);
        user.move(UpDownFlag.UP);
        // expect
        assertThatThrownBy(() -> user.getIndexOf(index))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("인덱스가 들어오면 정상적으로 UpDownFlag를 반환해야 한다.")
    void getIndexOfUpDownFlag() {
        // given
        user.move(UpDownFlag.UP);
        user.move(UpDownFlag.UP);
        user.move(UpDownFlag.DOWN);
        // expect
        assertThat(user.getIndexOf(2))
                .isEqualTo(UpDownFlag.DOWN);
    }
}