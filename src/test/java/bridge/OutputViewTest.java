package bridge;

import bridge.view.OutputView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import camp.nextstep.edu.missionutils.test.NsTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class OutputViewTest extends NsTest{

    @DisplayName("다리 출력 메소드에 리스트를 건네 주면 그 리스트를 토대로 맵을 생성해 출력되는지 확인.")
    @Test
    void printCorrectMap () {
        OutputView output = new OutputView();
        List<String> passHistory = List.of("U", "D", "U", "U");

        output.printMap(passHistory);

        assertThat(output()).contains(
                "[ O |   | O | O ]",
                "[   | O |   |   ]"
        );

    }

    @DisplayName("잘못된 칸을 선택한 다리 리스트를 건네 주더라도 이를 반영하여 맵을 생성해 출력하는지 확인.(위에 칸이 틀렸을 때)")
    @Test
    void printIncorrectUpCaseMap () {
        OutputView output = new OutputView();
        List<String> passHistory = List.of("U", "D", "U", "UX");

        output.printMap(passHistory);

        assertThat(output()).contains(
                "[ O |   | O | X ]",
                "[   | O |   |   ]"
        );
    }

    @DisplayName("잘못된 칸을 선택한 다리 리스트를 건네 주더라도 이를 반영하여 맵을 생성해 출력하는지 확인.(위에 칸이 틀렸을 때)")
    @Test
    void printIncorrectDownCaseMap () {
        OutputView output = new OutputView();
        List<String> passHistory = List.of("U", "D", "U", "DX");

        output.printMap(passHistory);

        assertThat(output()).contains(
                "[ O |   | O |   ]",
                "[   | O |   | X ]"
        );
    }

    @DisplayName("최종 결과가 올바르게 출력되는지 확인")
    @Test
    void printFinalResult () {
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
