package bridge.validatorTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.validator.BridgeSizeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeSizeValidatorTest {

    @DisplayName("숫자가 아닌 값을 입력받았을 때 예외가 발생하는지 확인")
    @Test
    public void checkInValidateNumber(){
        String size = "k";

        assertThatThrownBy(() -> new BridgeSizeValidator().validate(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위 외의 값을 입력받았을 때 예외가 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "21", "100"})
    public void checkInValidateRange(String size){
        assertThatThrownBy(() -> new BridgeSizeValidator().validate(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
