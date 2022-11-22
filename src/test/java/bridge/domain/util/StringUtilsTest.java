package bridge.domain.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringUtilsTest {
    @DisplayName("입력한 값의 빈칸 여부를 확인한다.")
    @ParameterizedTest
    @CsvSource({",true", "input,false"})
    public void validateByBlank(String input, boolean expected) {
        Assertions.assertThat(StringUtils.isBlank(input)).isEqualTo(expected);
    }
}