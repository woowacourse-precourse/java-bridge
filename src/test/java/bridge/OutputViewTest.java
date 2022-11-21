package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    private static final OutputView outputView = new OutputView();

    @DisplayName("게임 시작 문구 출력 테스트")
    @Test
    void guideStartMethodTest() {
        assertSimpleTest(() -> {
            outputView.guideStart();
            assertThat(output()).isEqualTo("다리 건너기 게임을 시작합니다.");
        });
    }

    @DisplayName("다리 길이 입력 안내 출력 테스트")
    @Test
    void guideBridgeSizeInputMethodTest() {
        assertSimpleTest(() -> {
            outputView.guideBridgeSizeInput();
            assertThat(output()).isEqualTo("다리의 길이를 입력해주세요. (3 이상 20 이하)");
        });
    }

    @DisplayName("게임 재시작/종료 코드 입력 안내 출력 테스트")
    @Test
    void guideGameCommandInputMethodTest() {
        assertSimpleTest(() -> {
            outputView.guideGameCommandInput();
            assertThat(output()).isEqualTo("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        });
    }

    @DisplayName("게임 최종 결과 출력 테스트1")
    @Test
    void printResultMethodTest1() {
        List<String> path = new ArrayList<>(List.of("U", "D", "D"));
        List<String> bridge = new ArrayList<>(List.of("U", "D", "U"));
        assertSimpleTest(() -> {
            outputView.printResult(path, bridge, 2_000_000_000);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2000000000"
            );
        });
        int upSideIndex = output().indexOf("[ O |   |   ]");
        int downSideIndex = output().indexOf("[   | O | X ]");
        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @DisplayName("게임 최종 결과 출력 테스트2")
    @Test
    void printResultMethodTest2() {
        List<String> path = new ArrayList<>(List.of("U", "D"));
        List<String> bridge = new ArrayList<>(List.of("U", "D"));
        assertSimpleTest(() -> {
            outputView.printResult(path, bridge, 2_147_483_647);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   ]",
                    "[   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2147483647"
            );
        });
        int upSideIndex = output().indexOf("[ O |   ]");
        int downSideIndex = output().indexOf("[   | O ]");
        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
