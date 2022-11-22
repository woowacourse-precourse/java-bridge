package bridge.View;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest extends NsTest {
    private final OutputView outputView = new OutputView();
    private final String upperMap = "[   ][   ][   ][   ][   ][   ][   ][   ]";
    private final String lowerMap = "[   ][   ][   ][   ][   ][   ][   ][   ]";

    @DisplayName("다리 칸의 구분 테스트")
    @Test
    void printMapTest() {
        outputView.printMap(upperMap, lowerMap);
        Assertions.assertThat(output()).contains("[   |   |   |   |   |   |   |   ]", "[   |   |   |   |   |   |   |   ]");
    }

    @DisplayName("최종 결과 출력 테스트")
    @Test
    void printResultTest() {
        int playCount = 7;
        String successOrNot = "실패";
        outputView.printMap(upperMap, lowerMap);
        outputView.printResult(playCount, successOrNot);
        Assertions.assertThat(output()).contains("[   |   |   |   |   |   |   |   ]",
          "[   |   |   |   |   |   |   |   ]",
          "최종 게임 결과",
          "[   |   |   |   |   |   |   |   ]",
          "[   |   |   |   |   |   |   |   ]",
          "게임 성공 여부: 실패",
          "총 시도한 횟수: 7"

        );
    }

    @Override
    protected void runMain() {

    }
}