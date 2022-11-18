package bridge;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ValidityCheckTest {

    private ValidityCheck validityCheck;

    @BeforeEach
    public void setUp() {
        validityCheck = new ValidityCheck();
    }

    @DisplayName("다리의 길이 입력시 문자를 입력하면 예외가 발생한다.")
    @Nested
    class 문자_확인 {
        @Test
        void case_문자() {
            String Test1 = "십오";
            String Test2 = "15j";

            assertFalse(validityCheck.stringChecker(Test1));
            assertFalse(validityCheck.stringChecker(Test2));
        }

        @Test
        void case_숫자() {
            String Test1 = "15";
            String Test2 = "20";

            assertTrue(validityCheck.stringChecker(Test1));
            assertTrue(validityCheck.stringChecker(Test2));
        }
    }

    @DisplayName("다리의 길이 범위(3~20)를 벗어난 숫자 입력시 예외가 발생한다.")
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

