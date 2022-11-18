package bridge;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilTest {

    public static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("숫자인지 아닌지 검사하는 테스트 코드")
    void isNumberTest(){
        boolean isTrue = Util.isNumber("1");
        assertThat(isTrue)
                .isTrue();

        boolean isFalse = Util.isNumber("a");
        assertThat(isFalse)
                .isFalse();
    }

    @Test
    @DisplayName("문자인지 아닌지 검사하는 테스트 코드")
    void isLetterTest(){
        boolean isTrue = Util.isLetter("a");
        assertThat(isTrue)
                .isTrue();

        boolean isFalse = Util.isLetter("1");
        assertThat(isFalse)
                .isFalse();
    }

    @Test
    @DisplayName("한 글자인지 아닌지 검사하는 테스트 코드")
    void isOneLetterTest(){
        boolean isTrue = Util.isOneLetter("a");
        assertThat(isTrue)
                .isTrue();

        boolean isFalse = Util.isOneLetter("aa");
        assertThat(isFalse)
                .isFalse();
    }


    @Test
    @DisplayName("여러 글자인지 아닌지 검사하는 테스트 코드")
    void isStringTest(){
        boolean isTrue = Util.isString("aa");
        assertThat(isTrue)
                .isTrue();

        boolean isFalse = Util.isString("a");
        assertThat(isFalse)
                .isFalse();
    }

    @Test
    @DisplayName("1입력시 U, 0입력시 D 리턴 테스트 코드")
    void convertBridgeNumberGeneratorTest(){
        assertThat(Util.convertBridgeNumberGenerator(1))
                .isEqualTo("U");

        assertThat(Util.convertBridgeNumberGenerator(0))
                .isEqualTo("D");
    }


    @Test
    @DisplayName("숫자열을 정수로 바꿔준다. 범위는 1~20이 최대다")
    void stringToIntegerTest(){
        assertThatThrownBy(() ->
                Util.stringToInteger("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() ->
                Util.stringToInteger("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() ->
                Util.stringToInteger("100000000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() ->
                Util.stringToInteger("010"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThat(Util.stringToInteger("1"))
                .isEqualTo(1);

        assertThat(Util.stringToInteger("20"))
                .isEqualTo(20);

    }

}