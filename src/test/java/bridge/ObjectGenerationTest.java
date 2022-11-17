package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ObjectGenerationTest {
    private final Utils utils = new Utils();

    @Test
    @DisplayName("새로운 UsersBridgeCrossStatus 객체를 생성한다.")
    void generateUsersBridgeCrossStatusTest() {
        UsersBridgeCrossStatus initialBridge = utils.makeInitialBridge();

        List<String> topSpace = initialBridge.getCurrentBridge().get(1);
        Assertions.assertThat(topSpace).isEqualTo(List.of("[", " ", " ", "]"));
        List<String> underSpace = initialBridge.getCurrentBridge().get(0);
        Assertions.assertThat(underSpace).isEqualTo(List.of("[", " ", " ", "]"));
    }
}
