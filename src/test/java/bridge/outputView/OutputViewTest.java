package bridge.outputView;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OutputViewTest extends NsTest {
    @ParameterizedTest
    @CsvSource(value = {"true,1,성공", "false,2,실패"})
    public void resultTest(boolean isSuccess, long value, String resultSuccess) {
        OutputView outputView = new OutputView();
        outputView.printResult(isSuccess, value);
        String result = String.format("게임 성공 여부: %s\n총 시도한 횟수: %d", resultSuccess, value);
        assertThat(output()).contains(result);

    }

    @Test
    public void printMapTest() {
        OutputView outputView = new OutputView();
        outputView.printMap(List.of(
                List.of("O", " ", " ")
                , List.of(" ", "O", "O")
        ));
        String result = "[ O |   |   ]\n"
                + "[   | O | O ]";
        assertThat(output()).contains(result);

    }

    @Override
    protected void runMain() {

    }
}