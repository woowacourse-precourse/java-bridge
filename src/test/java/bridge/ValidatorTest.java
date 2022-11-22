package bridge;

import bridge.utils.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"1234j", "123.", "1e1", "jeangyu"})
    public void 숫자가_맞는지_확인(String number){
        assertThatThrownBy(()->{
            Validator.isNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "22", "100", "1004"})
    public void 숫자의_범위를_확인(String number){
        assertThatThrownBy(()->{
            Validator.checkRange(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
