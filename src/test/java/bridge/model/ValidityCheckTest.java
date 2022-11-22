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

    @DisplayName("다리의 길이 범위(3~20)밖 일시 False / 범위 안 일시 True")
    @Nested
    class 범위_확인 {
        @Test
        void case_범위_밖() {
            String rangeOut1 = "21";
            String rangeOut2 = "2";

            assertFalse(validityCheck.numberRangeChecker(rangeOut1));
            assertFalse(validityCheck.numberRangeChecker(rangeOut2));
        }

        @Test
        void case_범위_안() {
            String rangeIn1 = "11";
            String rangeIn2 = "16";

            assertTrue(validityCheck.numberRangeChecker(rangeIn1));
            assertTrue(validityCheck.numberRangeChecker(rangeIn2));
        }
    }
}

