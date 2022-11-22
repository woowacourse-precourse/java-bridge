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
        }, 0, 0, 1,
                1, 1);
    }

    @Test
    void 게임성공_메세지_시도한_횟수_출력_테스트() {
        assertRandomNumberInRangeTest(() -> {
                    run("3", "D", "D", "D", "R", "U", "U", "D", "R", "D", "D", "R", "D", "U", "D");
                    assertThat(output()).contains(
                            "최종 게임 결과",
                            "게임 성공 여부: 성공",
                            "총 시도한 횟수: 4"
                    );
                }, 0, 0, 1,
                1, 1, 1,
                0, 1, 0,
                0, 1, 0);
    }

    @Override
    protected void runMain() {Application.main(new String[]{});}

}
