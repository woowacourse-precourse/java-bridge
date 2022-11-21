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

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputTestGameCommand {

    private static final String ERROR_MESSAGE = "[ERROR]";
    @DisplayName("게임 재시작 여부 입력 테스트 : R or Q 가 아닌 다른 영어 입력")
    @Test
    void testGameCommandByOtherEnglish() {
        String input = "a";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> new ValidationCheck().checkGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("게임 재시작 여부 입력 테스트 : 공백 입력")
    @Test
    void testGameCommandBySpaceBar() {
        String input = " ";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> new ValidationCheck().isBlank(Console.readLine()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
