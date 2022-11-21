package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest extends NsTest {
    private static final OutputView outputView = new OutputView();

    @DisplayName("게임 결과 출력 테스트")
    @Test
    void outputGameResult() {
        assertSimpleTest(() -> {
            outputView.printResult(List.of(new Bridge("O", " "), new Bridge("X", " ")), "실패", 1);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1");
        });
    }

    @Override
    protected void runMain() {

    }
}
