package bridge.model;

import bridge.model.MapFormat;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MapFormatTest {
    @Test
    void convertToStringByFormatTest() {
        MapFormat mapFormat = MapFormat.FORMAT;
        assertThat(mapFormat.convertToFormatStrings(
                List.of(
                        List.of("O", "X", " "),
                        List.of(" ", " ", " "))
        )).isEqualTo(List.of(
                "[ O | X |   ]",
                "[   |   |   ]"));

    }
}
