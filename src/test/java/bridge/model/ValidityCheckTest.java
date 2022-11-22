package bridge.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ValidityCheckTest {

    private ValidityCheck validityCheck;

    @BeforeEach
    public void setUp() {
        validityCheck = new ValidityCheck();
    }

    @DisplayName("다리의 길이가 문자 일시 False / 정수일시 True")
    @Nested
    class 문자_확인 {
        @Test
        void case_문자() {
            String testString1 = "십오";
            String testString2 = "15j";

            assertFalse(validityCheck.stringChecker(testString1));
            assertFalse(validityCheck.stringChecker(testString2));
        }

        @Test
        void case_숫자() {
            String testNumber1 = "15";
            String testNumber2 = "20";

            assertTrue(validityCheck.stringChecker(testNumber1));
            assertTrue(validityCheck.stringChecker(testNumber2));
        }
    }
}