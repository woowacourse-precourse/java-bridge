package userdomaintest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import userdomain.operator.UserException;


import static org.assertj.core.api.Assertions.*;

public class RetryTest {




    @DisplayName("재시작 입력 크기의 예외처리 기능을 테스트한다")
    @ValueSource(strings = {"RR", "RQ", "QR", "Q ", " R", "Q ", "R ","ㄱ ","!2"})
    @ParameterizedTest
    void 재시작_입력_크기_예외처리_테스트(String retry) {
        assertThatThrownBy(() -> new UserException().checkRetryInputSize(retry))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 입력 범위의 예외처리 기능을 테스트한다")
    @ValueSource(strings = {"q", "A", "u", "d", "ㄱ", "@"})
    @ParameterizedTest
    void 재시작_입력_범위_예외처리_테스트(String retry) {
        assertThatThrownBy(() -> new UserException().checkRetryInputRange(retry))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
