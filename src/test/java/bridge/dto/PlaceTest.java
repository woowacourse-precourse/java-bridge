package bridge.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PlaceTest {
    @DisplayName("사용자가 이동할 칸 정상 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    public void createPlace(String input) {
        assertThat(new Place(input)).isInstanceOf(Place.class);
    }

    @DisplayName("입력 가능한 값 외의 잘못된 값 입력에 대한 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {" U", "u", "d", "D ", "UD", "1"})
    public void validateByValue(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Place(input));
    }

    @DisplayName("사용자가 이동할 칸 입력을 안한 경우에 대한 예외 처리")
    @Test
    public void validateByBlank() {
        String input = "";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Place(input));
    }
}