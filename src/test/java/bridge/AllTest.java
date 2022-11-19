package bridge;

import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class AllTest extends NsTest {
    private static final OutputView outputView = new OutputView();
    @BeforeEach()
    void initTestCode() {
        outputView.initMap();
    }

    @DisplayName("전체 기능을 테스트 한다.")
    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "D","D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   |   | O ]",
                    "[   | O | O | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   |   |   | O ]");
            int downSideIndex = output().indexOf("[   | O | O | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0,0,1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
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
