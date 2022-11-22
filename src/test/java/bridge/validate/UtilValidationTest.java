package bridge.validate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import bridge.util.StringBufferUtility;
import org.junit.jupiter.api.Test;

class UtilValidationTest {

    @Test
    void popLastCharacter_기능_테스트() {
        String test = "TEST";
        String expected = test.substring(0, 3);
        StringBuffer stringBuffer = new StringBuffer(test);

        StringBufferUtility.popLastCharacter(stringBuffer);
        String actual = stringBuffer.toString();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void popLastCharacter_예외_테스트() {
        String empty = "";
        StringBuffer stringBuffer = new StringBuffer(empty);

        assertThatThrownBy(() -> StringBufferUtility.popLastCharacter(stringBuffer)).isInstanceOf(
                IllegalStateException.class);
    }
}