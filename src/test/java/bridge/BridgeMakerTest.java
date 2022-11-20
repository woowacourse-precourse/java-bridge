package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    private static BridgeMaker sut;

    @BeforeAll
    static void setup() {
        sut = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    static boolean isProperlyElement(String element) {
        return element.equals("U") || element.equals("D");
    }

    @DisplayName("주어진 사이즈를 전달받아 적절한 길이의 다리를 반환한다.")
    @ParameterizedTest(name = "다리 사이즈 테스트[{index}] => size가 {0}이라면 다리의 길이도 {0}이어야 한다.")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10})
    void putSizeThenReturningAppropriateSizeBridge(int size) {
        int actual = sut.makeBridge(size).size();
        assertThat(actual).isEqualTo(actual);
    }

    @DisplayName("다리의 각 요소는 U또는 D이다.")
    @ParameterizedTest(name = "다리 요소 테스트[{index}]")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10})
    void bridgeIncludesOnlyDorU(int size) {
        List<String> bridge = sut.makeBridge(size);
        for (String actual : bridge) {
            assertThat(isProperlyElement(actual)).isEqualTo(true);
        }
    }
}