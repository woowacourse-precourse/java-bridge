package bridge.utils;

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


    @ParameterizedTest
    @ValueSource(strings = {"Q", "R", "S", "A", "M"})
    public void 다리를_선택하는_알파벳이_맞는지_확인(String alpha){
        assertThatThrownBy(()->{
            Validator.isMoveAlpha(alpha);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"D", "U", "S", "QAQ", "DASKFJL"})
    public void 재시작을_결정하는_알파벳_인지_확인(String alpha){
        assertThatThrownBy(()->{
            Validator.isRestart(alpha);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}