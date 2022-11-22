package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BridgeTest {

    @DisplayName("특정 인덱스의 값을 제대로 반환하는지 확인한다.")
    @MethodSource("createCheckIndexOfBridgeData")
    @ParameterizedTest
    void checkIndexOfBridge(List<String> dataBridge, String dataExpected, Integer dataIndex) {
        // given
        Bridge bridge = new Bridge(dataBridge);
        String expected = dataExpected;

        // when
        String actual = bridge.get(dataIndex);

        // then
        assertEquals(actual, expected, "[ERROR] Bridge에서 특정 인덱스의 예상 값과 실제 값이 일치하지 않습니다.");
    }

    @DisplayName("Bridge의 크기를 정확히 반환하는지 확인한다.")
    @Test
    void checkSizeOfBridge() {
        // given
        Bridge bridge = new Bridge(List.of("U", "U", "U", "U", "U"));
        Integer expected = 5;

        // when
        Integer actual = bridge.size();

        // then
        assertEquals(actual, expected, "[ERROR] Bridge 크기의 예상 값과 실제 값이 일치하지 않습니다.");
    }

    static Stream<Arguments> createCheckIndexOfBridgeData() {
        return Stream.of(
                Arguments.of(List.of("U", "D", "U", "D"), "U", 2),
                Arguments.of(List.of("U", "D", "U", "D"), "D", 3)
        );
    }
}
