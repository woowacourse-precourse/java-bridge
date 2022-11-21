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
    void 다리_출력_정상_테스트() {
        List<String> bridge = Arrays.asList("U", "U", "D", "U", "D", "U", "U");
        List<String> crossed = Arrays.asList("U", "U", "D", "U", "D", "D");
        String lineName = "U";
        String correctResult = "[ o | o |   | o |   | x ]";

        String result = outputView.getCrossedLine(lineName, bridge, crossed);

        Assertions.assertThat(result).isEqualTo(correctResult);
    }
}
