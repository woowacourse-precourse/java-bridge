package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeTest {
    Bridge bridge;

    @BeforeEach
    void init() {
        bridge = new Bridge();
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 1, 0, 0));
        bridge.makeBridge(4, new BridgeMaker(numberGenerator));
    }

    @DisplayName("다리 데이터 그리기 테스트")
    @ParameterizedTest
    @CsvSource({"UUDD,[OO  ],[  OO]", "UUDU,[OO X],[  O ]"})
    void getMap(String pathString, String upperExpected, String lowerExpected) {
        upperExpected = upperExpected.substring(1, 5);
        lowerExpected = lowerExpected.substring(1, 5);
        List<String> paths = Arrays.asList(pathString.split(""));
        for (String path : paths) {
            bridge.move(path);
        }

        List<List<String>> map = bridge.getMap();
        List<String> upperResult = map.get(0);
        List<String> lowerResult = map.get(1);

        List<String> upper = Arrays.asList(upperExpected.split(""));
        List<String> lower = Arrays.asList(lowerExpected.split(""));

        assertThat(upperResult).containsExactly(
                upper.get(0),
                upper.get(1),
                upper.get(2),
                upper.get(3)
        );

        assertThat(lowerResult).containsExactly(
                lower.get(0),
                lower.get(1),
                lower.get(2),
                lower.get(3)
        );
    }

    @DisplayName("시도 횟 수 카운터 테스트")
    @ValueSource(strings = {"1", "3", "5"})
    @ParameterizedTest
    void tryCountTest(int count) {
        for (int i = 0; i < count; i++) {
            bridge.initBridge();
        }
        int tryCount = bridge.getTryCount();
        assertThat(tryCount).isEqualTo(count + 1);
    }

    @Test
    void gameSuccessTest() {
        assertThat(bridge.isGameSuccess()).isEqualTo(false);

        bridge.move("U");
        bridge.move("U");

        assertThat(bridge.isGameSuccess()).isEqualTo(false);

        bridge.move("D");
        bridge.move("D");

        assertThat(bridge.isGameSuccess()).isEqualTo(true);
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}