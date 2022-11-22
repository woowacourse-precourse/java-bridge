package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    private static BridgeMaker sut;

    static boolean isProperlyElement(String element) {
        return element.equals("U") || element.equals("D");
    }

    @BeforeEach
    void setup() {
        List<Integer> numbers = new ArrayList<>(List.of(0, 1, 0, 1, 0, 1, 0, 1, 0, 1));
        sut = new BridgeMaker(new ApplicationTest.TestNumberGenerator(numbers));
    }

    @DisplayName("주어진 사이즈를 전달받아 적절한 길이의 다리를 반환한다.")
    @ParameterizedTest(name = "다리 사이즈 테스트[{index}] => size가 {0}이라면 다리의 길이도 {0}이어야 한다.")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10})
    void putSizeThenReturningAppropriateSizeBridge(int size) {
        int actual = sut.makeBridge(size).size();
        assertThat(actual).isEqualTo(actual);
    }

    @DisplayName("다리의 각 요소는 U또는 D이다.")
    @ParameterizedTest(name = "다리 요소 테스트[{index}] => 만들어진 다리의 {0}번 인덱스는 {1}이다.)")
    @CsvSource(value = {"0:D", "1:U", "2:D", "3:U", "4:D", "5:U", "6:D", "7:U", "8:D", "9:U"}, delimiter = ':')
    void IndexOfBridgeIsExpectedValue(int source, String expected) {
        List<String> bridge = sut.makeBridge(10);
        String actual = bridge.get(source);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("주어진 인덱스의 각 요소를 검증한다.")
    @ParameterizedTest(name = "다리 요소 테스트[{index}] => {0}번 인덱스의 값은 U 또는 D이다.")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10})
    void bridgeIncludesOnlyDorU(int size) {
        List<String> bridge = sut.makeBridge(size);
        for (String actual : bridge) {
            assertThat(isProperlyElement(actual)).isTrue();
        }
    }
}