package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class PlayGameFailTest extends NsTest {

    @DisplayName("재시도로 실패된 게임 종료")
    @Test
    void 재시도로_실패된_게임() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "U", "Q");
            assertThat(output()).contains(
              "다리 건너기 게임을 시작합니다.",
              "다리의 길이를 입력해주세요.",
              "이동할 칸을 선택해주세요.",
              "[ O ]",
              "[   ]",
              "게임을 다시 시도할지 여부를 입력해주세요.",
              "최종 게임 결과",
              "[ O | X ]",
              "[   |   ]",
              "게임 성공 여부: 실패",
              "총 시도한 횟수: 2"
            );
            int upSideIndex = output().indexOf("[ O | X ]");
            int downSideIndex = output().indexOf("[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}
