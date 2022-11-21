package bridge;

import bridge.Domain.ValidCheck;
import bridge.UI.OutputView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidCheckTest {
    private OutputView outputView = new OutputView();
    @ParameterizedTest
    @CsvSource({"1,true","99,true","10,true","0,true","-1,false","abc,false","a1,false"})
    void isString_in_0to9Test(String input, boolean output) {
        assertThat(ValidCheck.isString_in_0to9(input)).isEqualTo(output);
    }
}
