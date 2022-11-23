package bridge;

import bridge.util.Validation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveTest extends NsTest {

    Validation validation = new Validation();

    @DisplayName("무브에 숫자가 입력되면 오류 발생")
    @Test
    void 무브_테스트_1번(){
        assertThrows(IllegalArgumentException.class,
                () -> validation.isValidateMove("11"));

    }

    @DisplayName("무브에 공백이나 더 긴 문자열이 입력되면 오류 발생")
    @Test
    void 무브_테스트_2번(){
        assertThrows(IllegalArgumentException.class,
                () -> validation.isValidateMove("abc"));

    }

    @DisplayName("무브에 예약되지 않은 문자가 입력되면 오류 발생")
    @Test
    void 무브_테스트_3번(){
        assertThrows(IllegalArgumentException.class,
                () -> validation.isValidateMove("u"));

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
