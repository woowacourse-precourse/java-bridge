package bridge.model.ScreenGenerator;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class WrongCaseGeneratorTest extends NsTest {

    List<String> answer = List.of("U", "D", "U", "D", "U", "D");
    ScreenGenerator wrongCaseGenerator = new WrongCaseGenerator();

    @DisplayName("입력 중 오답을 냈을 경우 생성되는 다리가 올바른가? ")
    @Test
    void checkWrongCaseGenerator() {
        wrongCaseGenerator.generatedTable(answer, 4);
        Assertions.assertThat(wrongCaseGenerator.toString())
            .isEqualTo("[ O |   | O |   |   ]\n" + "[   | O |   | O | X ]");
    }

    @DisplayName("입력 중 오답을 냈을 경우 생성되는 다리가 올바른가? 2")
    @Test
    void checkWrongCaseGenerator2() {
        wrongCaseGenerator.generatedTable(answer, 3);
        Assertions.assertThat(wrongCaseGenerator.toString()).
            isEqualTo("[ O |   | O | X ]\n" + "[   | O |   |   ]");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}