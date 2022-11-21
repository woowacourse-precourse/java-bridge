package bridge;

import bridge.domain.Bridge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class BridgeTest {
    private List<String> bridgeStrings;
    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridgeStrings = List.of("U","D","U","D");
        bridge = new Bridge(bridgeStrings);
    }

    @AfterEach
    void tearDown() {
        bridgeStrings = null;
        bridge = null;
    }

    @DisplayName("vaildateMove true인 경우")
    @ParameterizedTest
    @CsvSource({
            "U, 0",
            "D, 1",
            "U, 2",
            "D, 3"
    })
    void validateMoveTrue(String userDirection, int index) {
        boolean isValidate = bridge.validateMove(userDirection, index);
        Assertions.assertThat(isValidate).isEqualTo(true);
    }

    @DisplayName("vaildateMove false인 경우")
    @ParameterizedTest
    @CsvSource({
            "D, 0",
            "U, 1",
            "D, 2",
            "U, 3"
    })
    void validateMoveFalse(String userDirection, int index) {
        boolean isValidate = bridge.validateMove(userDirection, index);
        Assertions.assertThat(isValidate).isEqualTo(false);
    }

    @DisplayName("U 반환하는 인덱스.")
    @ParameterizedTest
    @ValueSource(ints = {0,2})
    void returnCertainIndexUpOrDownU(int index) {
        String certainDirection = bridge.returnCertainIndexUpOrDown(index);
        Assertions.assertThat(certainDirection).isEqualTo("U");
    }

    @DisplayName("D 반환하는 인덱스.")
    @ParameterizedTest
    @ValueSource(ints = {1,3})
    void returnCertainIndexUpOrDownD(int index) {
        String certainDirection = bridge.returnCertainIndexUpOrDown(index);
        Assertions.assertThat(certainDirection).isEqualTo("D");
    }
}