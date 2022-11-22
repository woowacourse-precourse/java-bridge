package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingTest {
    @ParameterizedTest
    @CsvSource({"U,true", "D,false"})
    void 위이면_true_아래이면_false를_반환(String input, boolean result) {
        Moving moving = new Moving(input);

        assertThat(moving.isUpper()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"U,0,O", "D,0,X", "U,1,X", "D,1,O"})
    void 다리와_값이_같으면_O_다르면_X를_반환(String input, int index, String result) {
        Bridge bridge = new Bridge(List.of("U", "D"));

        Moving moving = new Moving(input);
        assertThat(moving.isMoving(bridge, index)).isEqualTo(result);
    }
}
