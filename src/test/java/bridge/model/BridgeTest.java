package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    private Bridge bridge;

    @BeforeEach
    void init() {
        bridge = new Bridge(List.of("U", "U", "D"));
    }

    @DisplayName("이동할 수 있는 칸인 경우 true 반환")
    @CsvSource(value = {"U:0", "U:1", "D:2"}, delimiter = ':')
    @ParameterizedTest
    void ableToMove(String location, int index) {
        assertThat(bridge.ableToMove(location, index))
                .isEqualTo(true);
    }

    @DisplayName("이동할 수 없는 칸인 경우 false 반환")
    @CsvSource(value = {"D:0", "D:1", "U:2"}, delimiter = ':')
    @ParameterizedTest
    void notAbleToMove(String location, int index) {
        assertThat(bridge.ableToMove(location, index))
                .isEqualTo(false);
    }
}
