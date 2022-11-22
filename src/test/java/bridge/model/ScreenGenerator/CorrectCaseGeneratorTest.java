package bridge.model.ScreenGenerator;

import bridge.Application;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import camp.nextstep.edu.missionutils.test.NsTest;

class CorrectCaseGeneratorTest extends NsTest {

    @DisplayName("정답을 맞추었을 경우 생성되는 다리가 올바른가? ")
    @Test
    void checkCorrectCaseGenerator() {
        List<String> answer = List.of("U", "D", "U", "D", "U", "D");
        ScreenGenerator correctCaseGenerator = new CorrectCaseGenerator();
        correctCaseGenerator.generatedTable(answer, 4);
        Assertions.assertThat(correctCaseGenerator.toString())
                .isEqualTo("[ O |   | O |   | O ]\n" + "[   | O |   | O |   ]");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}