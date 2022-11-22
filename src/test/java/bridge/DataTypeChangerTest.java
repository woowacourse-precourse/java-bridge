package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.util.DataTypeChanger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DataTypeChangerTest {

    private final DataTypeChanger dataTypeChanger = new DataTypeChanger();

    @DisplayName("숫자가 1이면 U로, 0이면 D로 변환해주는 메서드")
    @Test
    public void convertToUpOrDownTest() {
        // given
        int number = 1;
        String str = "U";

        // when
        String up = dataTypeChanger.convertToUpOrDown(number);

        // then
        assertThat(up).isEqualTo(str);
    }

    @DisplayName("문자열을 정수로 변환해주는 메서드")
    @Test
    public void StringToInteger() {
        // given
        String str = "10";
        int number = 10;

        // when
        int intStr = dataTypeChanger.StringToInteger(str);

        // then
        assertThat(intStr).isEqualTo(number);
    }
}
