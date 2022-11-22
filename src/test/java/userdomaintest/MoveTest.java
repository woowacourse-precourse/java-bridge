package userdomaintest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import userdomain.operator.UserException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveTest {


    @DisplayName("이동 입력 크기의 예외처리 기능을 테스트한다")
    @ValueSource(strings = {"UU", "DD", "D ", "U "})
    @ParameterizedTest
    void 이동_입력_크기_예외처리_테스트(String userMove) {
        assertThatThrownBy(() -> new UserException().checkMoveInputSize(userMove))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 입력 범위의 예외처리 기능을 테스트한다")
    @ValueSource(strings = {"Q", "A", "u", "d", "ㄱ", "@"})
    @ParameterizedTest
    void 이동_입력_범위_예외처리_테스트(String userMove) {
        assertThatThrownBy(() -> new UserException().checkMoveInputRange(userMove))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
