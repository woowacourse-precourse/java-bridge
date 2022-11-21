package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest extends NsTest {

    @DisplayName("현재까지 이동한 칸 출력")
    @Test
    void 다리상태_DDU() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "D", "U");
            assertThat(output()).contains(
                    "[   |   | O ]",
                    "[ O | O |   ]"
            );

            int upSideIndex = output().indexOf("[   |   | O ]");
            int downSideIndex = output().indexOf("[ O | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 0, 1);
    }

    @DisplayName("게임 실패 후 재시작")
    @Test
    void 게임실패_재시작() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "R", "D", "D", "U");
            assertThat(output()).contains(
                    "[   |   | O ]",
                    "[ O | O |   ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
            );
        }, 0, 0, 1);
    }

    @DisplayName("게임 실패 후 종료")
    @Test
    void 게임실패_종료() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "Q");
            assertThat(output()).contains(
                    "게임 성공 여부: 실패"
            );
        }, 0, 0, 1);
    }



    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}