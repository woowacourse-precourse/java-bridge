package bridge;

import bridge.exception.Exception;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
class ExceptionTest {
    @DisplayName("다리의 길이 입력에, 3이상 20이하인 숫자가 오면, 예외가 발생한다")
    @Test
    void NotValidateSize(){
        assertThatThrownBy(() -> new Exception().checkNumberRangeException("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("위(U) 아래(D)가 아닌 문자가 들어오면, 예외가 발생한다")
    @Test
    void NotVaildateMove(){
        assertThatThrownBy(() -> new Exception().checkCorrectUpOrDownException("UD"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다시하기(R) 종료(Q)가 아닌 문자가 들어오면, 예외가 발생한다")
    @Test
    void NotValidateRetry(){
        assertThatThrownBy(() -> new Exception().checkRestartOrDoneException("RQ"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
