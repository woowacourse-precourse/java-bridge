package bridge;

import bridge.util.Validation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandTest extends NsTest {

    Validation validation = new Validation();

    @DisplayName("커맨드에 숫자가 입력되면 오류 발생")
    @Test
    void 커맨드_테스트_1번(){
        assertThrows(IllegalArgumentException.class,
                () -> validation.isValidateCommand("11"));

    }

    @DisplayName("커맨드에 공백이나 더 긴 문자열이 입력되면 오류 발생")
    @Test
    void 커맨드_테스트_2번(){
        assertThrows(IllegalArgumentException.class,
                () -> validation.isValidateCommand("abc"));

    }

    @DisplayName("커맨드에 예약되지 않은 문자가 입력되면 오류 발생")
    @Test
    void 커맨드_테스트_3번(){
        assertThrows(IllegalArgumentException.class,
                () -> validation.isValidateCommand("r"));

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
