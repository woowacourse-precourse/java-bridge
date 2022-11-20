package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeTest {

    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "U", "D"));
    }

    @DisplayName("이동 가능한 칸인지 확인해주는 작업이 정상적으로 이루어지는지 확인")
    @ParameterizedTest
    @CsvSource({
            "U, 0, true",
            "U, 1, false",
            "D, 1, true",
            "D, 2, false",
            "D, 3, true"
    })
    void checkCheckingMovableSquareWorksProperly(String movement, int index, boolean expected) {
        assertEquals(bridge.isAvailableSquare(index, movement), expected);
    }

    @DisplayName("마지막 원소인지 확인해주는 작업이 정상적으로 이루어지는지 확인")
    @ParameterizedTest
    @CsvSource({
            "1, false",
            "2, false",
            "3, true"
    })
    void checkCheckingLastIndexWorksProperly(int index, boolean expected) {
        assertEquals(bridge.isLastIndex(index), expected);
    }
}
