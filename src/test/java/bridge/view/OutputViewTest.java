package bridge.view;

import bridge.view.utils.CustomStringBuilderForBridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @DisplayName("출력 확인 테스트 - 도중 틀렸을 경우")
    @Test
    void givenBridgeAndUserAnswer_whenPrintMap_thenPrintPartialBridgePattern() {
        //Given
        List<String> bridge = List.of("U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D");  // size : 12
        List<String> userAnswer = List.of("U", "D", "U", "U");
        String result =
                        "[ O |   | O | X ]\n" +
                        "[   | O |   |   ]";

        //When
        String printMapResult = printMap(bridge, userAnswer);

        //Then
        assertThat(result).isEqualTo(printMapResult);

    }

    @DisplayName("출력 확인 테스트 - 전체 다 맞았을 경우")
    @Test
    void givenBridgeAndUserAnswer_whenPrintMap_thenPrintTotalBridgePattern() {
        //Given
        List<String> bridge = List.of("U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D");  // size : 12
        List<String> userAnswer = List.of("U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D");
        String result =
                        "[ O |   | O |   | O |   | O |   | O |   | O |   ]\n" +
                        "[   | O |   | O |   | O |   | O |   | O |   | O ]";

        //When
        String printMapResult = printMap(bridge, userAnswer);

        //Then
        assertThat(result).isEqualTo(printMapResult);

    }


    private String printMap(List<String> bridge, List<String> userAnswer) {
        CustomStringBuilderForBridge stringBuilderBridge = new CustomStringBuilderForBridge();

        stringBuilderBridge.addStartBracket();
        compareUserAndAnswer(bridge, userAnswer, stringBuilderBridge);
        stringBuilderBridge.addEndBracket();

        return stringBuilderBridge.getUpperBridge().toString() + "\n" + stringBuilderBridge.getLowerBridge().toString();
    }

    private void compareUserAndAnswer(List<String> bridge, List<String> userAnswer, CustomStringBuilderForBridge stringBuilderBridge) {
        for (int i = 0; i < userAnswer.size(); i++) {
            if (bridge.get(i) == userAnswer.get(i)) {
                stringBuilderBridge.addO(userAnswer.get(i));
            } else if (bridge.get(i) != userAnswer.get(i)) {
                stringBuilderBridge.addX(userAnswer.get(i));
            }
            if (i != userAnswer.size() - 1) {
                stringBuilderBridge.addStick();
            }
        }
    }

}