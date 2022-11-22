package exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력값 검사 테스트")
class CustomExceptionTest {

    private CustomException customException;

    @BeforeEach
    void setUp() {
        customException = new CustomException();
    }

    @DisplayName("true case : 다리 길이 3")
    @Test
    void checkBridgeSize() {
        int input = 3;
        boolean bool = customException.checkBridgeSize(input);
        assertThat(bool).isEqualTo(true);
    }

    @DisplayName("false case : 다리 길이 21")
    @Test
    void checkBridgeSize2() {
        int input = 21;
        boolean bool = customException.checkBridgeSize(input);
        assertThat(bool).isEqualTo(false);
    }

    @DisplayName("true case : move U")
    @Test
    void checkMove() {
        String input = "U";
        boolean bool = customException.checkMove(input);
        assertThat(bool).isEqualTo(true);
}

    @DisplayName("false case : move u")
    @Test
    void checkMove2() {
        String input = "u";
        boolean bool = customException.checkMove(input);
        assertThat(bool).isEqualTo(false);
    }

    @DisplayName("true case : retry R")
    @Test
    void checkRetry() {
        String input = "R";
        boolean bool = customException.checkGameCommand(input);
        assertThat(bool).isEqualTo(true);
    }

    @DisplayName("false case : retry q")
    @Test
    void checkRetry2() {
        String input = "q";
        boolean bool = customException.checkGameCommand(input);
        assertThat(bool).isEqualTo(false);
    }
}