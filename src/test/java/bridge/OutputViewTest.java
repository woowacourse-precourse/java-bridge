package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class OutputViewTest {

    OutputView outputView;

    public OutputViewTest() {
        this.outputView = new OutputView();
    }

    @Test
    void 다리_라인_출력_정상_테스트() {
        List<String> bridge = Arrays.asList("U", "U", "D", "U", "D", "U", "U");
        List<String> crossed = Arrays.asList("U", "U", "U", "U", "D", "D");
        String lineName = "U";
        String correctResult = "[ O | O | X | O |   |   ]";

        String result = outputView.getCrossedLine(lineName, bridge, crossed);

        Assertions.assertThat(result).isEqualTo(correctResult);
    }

    @Test
    void 다리_출력_정상_테스트() {
        List<String> bridge = Arrays.asList("U", "U", "D", "U", "D", "U", "U");
        List<String> crossed = Arrays.asList("U", "U", "D", "U", "D", "D");
        String correctResult = "[ O | O |   | O |   |   ]\n[   |   | O |   | O | X ]";

        String result = outputView.getMap(bridge, crossed);

        Assertions.assertThat(result).isEqualTo(correctResult);
    }
}
