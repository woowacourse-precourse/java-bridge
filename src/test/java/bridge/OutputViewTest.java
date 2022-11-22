package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest extends NsTest {

    @Test
    void 사다리_모양_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "D", "D", "U", "U", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   |   | O | O |   ]",
                    "[ O | O |   |   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 0, 0, 1, 1, 1);
    }

    @Override
    protected void runMain() {Application.main(new String[]{});}

}
