package bridge.input;

import bridge.Application;
import bridge.validation.ValidationCheck;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputTestMovingStr extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";


    @DisplayName("이동할 칸 입력 테스트 : U or D 가 아닌 다른 영어 입력")
    @Test
    void testMovingByOtherEnglish() {
        String input = "a";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> new ValidationCheck().checkMovingEnum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("이동할 칸 입력 테스트 : 공백 입력")
    @Test
    void testMovingBySpaceBar() {
        String input = " ";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> new ValidationCheck().isBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
