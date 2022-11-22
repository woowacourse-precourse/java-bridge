package bridge;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilTest {

    public static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("숫자인지 아닌지 검사하는 테스트 코드")
    void isNumberTest() {
        //정상적인 값
        {
            boolean isTrue = Util.isNumber("1");
            assertThat(isTrue)
                    .isTrue();
        }

        //잘못된 값
        {
            boolean isFalse = Util.isNumber("a");
            assertThat(isFalse)
                    .isFalse();
        }
    }

    @Test
    @DisplayName("문자인지 아닌지 검사하는 테스트 코드")
    void isLetterTest() {
        //정상적인 값
        {
            boolean isTrue = Util.isLetter("a");
            assertThat(isTrue)
                    .isTrue();
        }

        //잘못된 값
        {
            boolean isFalse = Util.isLetter("1");
            assertThat(isFalse)
                    .isFalse();
        }
    }

    @Test
    @DisplayName("한 글자인지 아닌지 검사하는 테스트 코드")
    void isOneLetterTest() {
        //정상적인 값
        {
            boolean isTrue = Util.isOneLetter("a");
            assertThat(isTrue)
                    .isTrue();
        }

        //잘못된 값
        {
            boolean isFalse = Util.isOneLetter("aa");
            assertThat(isFalse)
                    .isFalse();
        }
    }


    @Test
    @DisplayName("여러 글자인지 아닌지 검사하는 테스트 코드")
    void isStringTest() {
        //정상적인 값
        {
            boolean isTrue = Util.isString("aa");
            assertThat(isTrue)
                    .isTrue();
        }

        //비 정상적인 값
        {
            boolean isFalse = Util.isString("a");
            assertThat(isFalse)
                    .isFalse();
        }
    }

    @Test
    @DisplayName("1입력시 U, 0입력시 D 리턴 테스트 코드")
    void convertBridgeNumberGeneratorTest() {
        //1은 U
        {
            assertThat(Util.convertBridgeNumberGenerator(1))
                    .isEqualTo("U");
        }

        //0은 D
        {
            assertThat(Util.convertBridgeNumberGenerator(0))
                    .isEqualTo("D");
        }
    }


    @Test
    @DisplayName("숫자열을 정수로 바꿔준다. 범위는 1~20이 최대다")
    void stringToIntegerTest() {
        //0인 수
        {
            assertThatThrownBy(() ->
                    Util.stringToInteger("0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        // 음수 일 결우
        {
            assertThatThrownBy(() ->
                    Util.stringToInteger("-1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        //너무 큰 수
        {
            assertThatThrownBy(() ->
                    Util.stringToInteger("100000000000"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        //앞에 0이 들어갈 경우
        {
            assertThatThrownBy(() ->
                    Util.stringToInteger("010"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        //허용된 최소값
        {
            assertThat(Util.stringToInteger("1"))
                    .isEqualTo(1);
        }

        //허용된 최대값
        {
            assertThat(Util.stringToInteger("20"))
                    .isEqualTo(20);
        }
    }
}