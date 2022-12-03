package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;



public class BridgeMoveTest extends NsTest {

    private final String ERROR_MESSAGE = "[ERROR]";

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 다리_건너기_실패_종료() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D","Q");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[   ]",
                "[ X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            );
        }, 1, 0, 1);
    }
    @Test
    void 다리_건너기_실패_재시도() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U","D","D","R","U","D","U");
            assertThat(output()).contains(
                "[ O |   |   ]",
                "[   | O | X ]",
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            );
        }, 1, 0, 1);
    }
}
