package bridge;

import bridge.view.OutputView;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class OutputViewTest extends NsTest{

    @Test
    void 성공_다리_출력 () {
        OutputView output = new OutputView();
        List<String> passHistory = List.of("U", "D", "U", "U");

        output.printMap(passHistory);

        assertThat(output()).contains(
                "[ O |   | O | O ]",
                "[   | O |   |   ]"
        );

    }

    @Test
    void 실패_다리_출력1 () {
        OutputView output = new OutputView();
        List<String> passHistory = List.of("U", "D", "U", "UX");

        output.printMap(passHistory);

        assertThat(output()).contains(
                "[ O |   | O | X ]",
                "[   | O |   |   ]"
        );
    }

    @Test
    void 실패_다리_출력2 () {
        OutputView output = new OutputView();
        List<String> passHistory = List.of("U", "D", "U", "DX");

        output.printMap(passHistory);

        assertThat(output()).contains(
                "[ O |   | O |   ]",
                "[   | O |   | X ]"
        );
    }

    @Test
    void 최종_결과_출력 () {
        OutputView output = new OutputView();
        List<String> passHistory= List.of("U","D","D","U");

        List<String> result = List.of(
        "최종 게임 결과",
        "[ O |   |   | O ]",
        "[   | O | O |   ]",
        "게임 성공 여부: 성공",
        "총 시도한 횟수: 3"
        );

        output.printResult(3,true, passHistory);

        assertThat(output()).contains(result);

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
