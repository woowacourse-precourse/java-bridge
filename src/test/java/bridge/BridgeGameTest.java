package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest extends NsTest {
    private Stream<String> bridgeStream;

    @BeforeEach
    void initialize() {
        String[] bridge = new String[]{"[ O ]", "[   ]", "[ O |   ]", "[   | O ]", "[ O |   | O ]", "[   | O |   ]"};
        bridgeStream = Arrays.stream(bridge);
    }

    @Test
    @DisplayName("정답에 따라 출력용 지도를 제대로 생성하는 지 포함 여부를 확인한다.")
    void createMapTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            bridgeStream.forEach(string -> assertThat(output()).contains(string));
        }, 1, 0, 1);
    }

    private boolean isOrdered(List<Integer> item) {
        for (int index = 0; index < item.size() - 1; index++) {
            if (item.get(index) >= item.get(index + 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    @DisplayName("정답에 따라 출력용 지도를 제대로 생성하는 지 순서를 확인한다.")
    void createMapOrderTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            List<Integer> indices = bridgeStream.map(string -> output().indexOf(string)).collect(Collectors.toList());
            assertThat(isOrdered(indices)).isEqualTo(true);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
