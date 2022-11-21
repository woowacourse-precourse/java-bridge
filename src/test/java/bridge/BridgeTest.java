package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeTest {

    @ParameterizedTest
    @CsvSource({"0,U,O", "0,D,X", "1,D,O", "1,U,X"})
    void 이동할_칸과_다리의_값을_비교(int index, String input, String result) {
        Bridge bridge = new Bridge(List.of("U", "D"));
        assertThat(bridge.compareTo(index, input)).isEqualTo(result);
    }
}
