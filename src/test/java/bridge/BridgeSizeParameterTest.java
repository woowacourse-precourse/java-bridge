package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeSizeParameterTest {
    @ParameterizedTest
    @ValueSource(ints = {1,2,21,23,25,99})
    void if_out_of_range(int input) {
        BridgeSizeException bridgeSizeException = assertThrows(BridgeSizeException.class, () -> new BridgeSizeParameter(input));

        assertThat(bridgeSizeException.getMessage()).contains("[ERROR]");
    }
}