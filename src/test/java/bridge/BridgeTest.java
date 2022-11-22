package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BridgeTest {
    final static List<String> defaultBridge = List.of("U", "U", "D", "D");
    Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(defaultBridge);
    }

    @ParameterizedTest
    @MethodSource("generateWrongBridgeValue")
    void 다리_생성_잘못된_값_입력_예외_테스트(List<String> movableSides) {
        assertThatThrownBy(() -> new Bridge(movableSides))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateOutRangedBridge")
    @DisplayName("사이즈 예외 테스트")
    void 다리_생성_사이즈_예외_테스트(List<String> movableSides) {
        assertThatThrownBy(() -> new Bridge(movableSides))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"U:0:true", "D:2:true", "U:2:false", "U:3:false"}, delimiter = ':')
    @DisplayName("이동 가능 여부 묻기")
    void 이동_가능_여부_묻기_테스트(String selectedSides, String position, String isMovableSide) {
        assertThat(bridge.isMovableSide(selectedSides, Integer.valueOf(position)))
                .isEqualTo(Boolean.valueOf(isMovableSide));
    }

    @ParameterizedTest
    @MethodSource("generateMovableBridge")
    @DisplayName("게임에서 이겼는지 확인 (=사용자가 마지막 위치에 있는지 확인)")
    void 마지막_위치_확인_테스트(List<String> movableSide) {
        bridge = new Bridge(movableSide);
        assertThat(bridge.isLastPosition(movableSide.size() - 1))
                .isTrue();
    }

    static Stream<Arguments> generateWrongBridgeValue() {
        return Stream.of(
                Arguments.of(Arrays.asList("")),
                Arguments.of(Arrays.asList(" ")),
                Arguments.of(Arrays.asList("a")),
                Arguments.of(Arrays.asList("1")),
                Arguments.of(Arrays.asList("u")),
                Arguments.of(Arrays.asList("d")),
                Arguments.of(Arrays.asList("UU")),
                Arguments.of(Arrays.asList("DD")),
                Arguments.of(Arrays.asList("U", "D ")),
                Arguments.of(Arrays.asList("U", "D ", "U")),
                Arguments.of(Arrays.asList("U.", "D ", "U"))
        );
    }

    static Stream<Arguments> generateOutRangedBridge() {
        return Stream.of(
                Arguments.of(Arrays.asList("U")),
                Arguments.of(Arrays.asList("U")),
                Arguments.of(Arrays.asList("U", "U")),
                Arguments.of(Arrays.asList(
                        "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
                        "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U"
                ))
        );
    }

    static Stream<Arguments> generateMovableBridge() {
        return Stream.of(
                Arguments.of(Arrays.asList("U", "U", "U")),
                Arguments.of(Arrays.asList("U", "U", "U", "U")),
                Arguments.of(Arrays.asList("U", "U", "U", "U", "U")),
                Arguments.of(Arrays.asList(
                        "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
                        "U", "U", "U", "U", "U", "U", "U", "U", "U", "U"
                ))
        );
    }
}
