package bridge;

import org.junit.jupiter.api.*;

import static bridge.ErrorMessage.ER_STRING;
import static org.junit.jupiter.api.Assertions.*;

class ValidityCheckTest {

    private ValidityCheck validityCheck;

    @BeforeEach
    public void setUp() {
        validityCheck = new ValidityCheck();
    }

    @DisplayName("다리의 길이 입력시 문자를 입력하면 예외가 발생한다.")
    @Nested
    class 문자_검사 {

        @Test현
        void case1() {
            Throwable illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                validityCheck.stringChecker("십오");
            });
            assertEquals(ER_STRING.getMessage(), illegalArgumentException.getMessage());
        }

        @Test
        void case2() {
            Throwable illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                validityCheck.stringChecker("10s");
            });
            assertEquals(ER_STRING.getMessage(), illegalArgumentException.getMessage());
        }

    }

}