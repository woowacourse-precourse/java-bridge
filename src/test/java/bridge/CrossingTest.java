package bridge;

import bridge.Enum.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CrossingTest {
    @ParameterizedTest
    @CsvSource(value = {"0:D", "1:U"}, delimiter = ':')
    @DisplayName("toString 메소드 테스트")
    void toStringTest(int number, String string) {
        String actual = Direction.toString(number);
        assertThat(actual).isEqualTo(string);
    }
}
