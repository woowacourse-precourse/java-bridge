package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UtilTest {

    @Test
    @DisplayName("숫자인지 아닌지 검사합니다")
    void isNumberTest(){
        boolean isTrue = Util.isNumber("1");
        assertThat(isTrue)
                .isTrue();

        boolean isFalse = Util.isNumber("a");
        assertThat(isFalse)
                .isFalse();
    }

}