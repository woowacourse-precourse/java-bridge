package bridge.entity.BridgeGame;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.data.entity.BridgeGame;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("다리 건너기 게임을 시작할 땐")
public class BridgeGameInitTest {
    @DisplayName("U와 D로 이루어진, 길이가 3 ~ 20 이내의 문자열 리스트를 받아야 한다.")
    @ParameterizedTest
    @MethodSource("passingTestParams")
    void passingTest(List<String> bridge) {
        new BridgeGame(bridge);
    }

    private static Stream<List<String>> passingTestParams() {
        return Stream.of(
                Arrays.asList("UUD".split("")),
                Arrays.asList("UUUU".split("")),
                Arrays.asList("DDDDDDDDDDDDDDDDDDDD".split(""))
        );
    }

    @DisplayName("길이가 3 ~ 20 범위 이외라면, 실패해야 한다.")
    @ParameterizedTest
    @MethodSource("sizeFailTestParams")
    void sizeFailTest(List<String> bridge) {
        assertThatThrownBy(() -> new BridgeGame(bridge))
                .isInstanceOf(IllegalStateException.class);
    }

    private static Stream<List<String>> sizeFailTestParams() {
        return Stream.of(
                Arrays.asList("UU".split("")),
                Arrays.asList("DDDDDDDDDDDDDDDDDDDDD".split(""))
        );
    }

    @DisplayName("문자열 리스트에 U, D 가 아닌 다른 문자가 들어있다면, 실패해야 한다.")
    @ParameterizedTest
    @MethodSource("componentFailTestParams")
    void componentFailTest(List<String> bridge) {
        assertThatThrownBy(() -> new BridgeGame(bridge))
                .isInstanceOf(IllegalStateException.class);
    }

    private static Stream<List<String>> componentFailTestParams() {
        return Stream.of(
                Arrays.asList("UUu".split("")),
                Arrays.asList("디DDDDDDDDDDDDDDDDDDD".split("")),
                Arrays.asList("1111".split("")),
                Arrays.asList("^_^".split(""))
        );
    }
}
