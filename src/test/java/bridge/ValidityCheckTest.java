package bridge;

import org.junit.jupiter.api.*;

import static bridge.ErrorMessage.*;
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

        @Test
        void case_1() {
            Throwable illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                validityCheck.stringChecker("십오");
            });
            assertEquals(ER_BRIDGE_LENGTH_INPUT.getMessage(), illegalArgumentException.getMessage());
        }

        @Test
        void case_2() {
            Throwable illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                validityCheck.stringChecker("10s");
            });
            assertEquals(ER_BRIDGE_LENGTH_INPUT.getMessage(), illegalArgumentException.getMessage());
        }

    }

    @DisplayName("다리의 길이 범위(3~20)를 벗어난 숫자 입력시 예외가 발생한다.")
    @Nested
    class 범위_검사 {

        @Test
        void case_1() {
            Throwable illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                validityCheck.numberRangeChecker("21");
            });
            assertEquals(ER_BRIDGE_LENGTH_INPUT.getMessage(), illegalArgumentException.getMessage());
        }

        @Test
        void case_2() {
            Throwable illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                validityCheck.numberRangeChecker("0");
            });
            assertEquals(ER_BRIDGE_LENGTH_INPUT.getMessage(), illegalArgumentException.getMessage());

        }

    }
}