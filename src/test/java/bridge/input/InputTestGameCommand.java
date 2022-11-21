package bridge.input;

import bridge.Application;
import bridge.validation.ValidationCheck;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputTestGameCommand extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private ValidationCheck validationCheck;
    @BeforeEach
    void beforeTestSetting(){
        validationCheck = new ValidationCheck();
    }


    @DisplayName("게임 재시작 여부 입력 테스트 : R or Q 가 아닌 다른 영어 입력")
    @Test
    void testGameCommandByOtherEnglish() {
        InputStream in = new ByteArrayInputStream("a".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> validationCheck.checkGameCommand(Console.readLine()))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("게임 재시작 여부 입력 테스트 : 공백 입력")
    @Test
    void testMovingBySpaceBar() {
        InputStream in = new ByteArrayInputStream(" ".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> validationCheck.isBlank(Console.readLine()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
