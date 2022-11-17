package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UtilTest {

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
    
}