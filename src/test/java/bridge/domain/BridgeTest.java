package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

    @Test
    @DisplayName("다리 길이가 3 ~ 20 아닐 때 예외")
    void validateBridgeLength() {
        List<String> length2 = List.of("U", "D");
        List<String> length21 = List.of(
                "U", "D", "U", "D", "U",
                "D", "U", "D", "U", "D",
                "U", "D", "U", "D", "U",
                "D", "U", "D", "U", "D",
                "U");

        assertThatThrownBy(() -> new Bridge(length2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new Bridge(length21))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("다리 생성 확인")
    void createBridge() {
        List<String> random = List.of("U", "D", "U");

        assertThat(new Bridge(random)).isEqualTo(new Bridge(random));
    }

    @ParameterizedTest
    @DisplayName("N번째 다리와 유저 입력 비교 후 움직임 확인")
    @CsvSource(value = {
            "0,U,false",
            "1,D,true",
            "2,U,false",
            "3,D,true"
    })
    void move(int index, String input, boolean move) {
        Bridge actual = new Bridge(List.of("D", "D", "D", "D"));

        assertThat(actual.movable(input, index)).isEqualTo(move);
    }
}
