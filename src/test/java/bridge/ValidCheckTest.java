package bridge;

import bridge.domain.ValidCheck;
import bridge.ui.OutputView;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidCheckTest {
    private OutputView outputView = new OutputView();

    @ParameterizedTest
    @CsvSource({"1,true", "99,true", "10,true", "0,true", "-1,false", "abc,false", "a1,false"})
    void isString_in_0to9Test(String str, boolean output) {
        assertThat(ValidCheck.isString_in_0to9(str)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({"3,true", "10,true", "12,true", "20,true", "-1,false", "99,false", "0,false"})
    void isRange_3to20Test(int num, boolean output) {
        assertThat(ValidCheck.isRange_3to20(num)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({"3,false", "10,false", "D,true", "U,true", "UU,true", "abc,false", "R,false"})
    void isUorDTest(String str, boolean output) {
        assertThat(ValidCheck.isUorD(str)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({"3,false", "10,false", "R,true", "Q,true", "RR,true", "abc,false", "D,false"})
    void isRorQTest(String str, boolean output) {
        assertThat(ValidCheck.isRorQ(str)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource({"abc,false", "1,true", "R,true", "QQ,false", "RR,false", "DD,false", "UUU,false"})
    void isLength1Test(String str, boolean output) {
        assertThat(ValidCheck.isLength1(str)).isEqualTo(output);
    }
}
