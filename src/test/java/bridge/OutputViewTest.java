package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import bridge.view.OutputView;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {

    @DisplayName("initTopBridgeTest 진행 후에 '['의 문자열이 반환되어야 한다.")
    @Test
    public void initTopBridgeTest() {
        //given
        OutputView outputView = new OutputView();
        String expectedValue = "[";

        //when
        String actualValue = outputView.initTopBridge().toString();

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("initBottomBridgeTest 진행 후에 '['의 문자열이 반환되어야 한다.")
    @Test
    public void initBottomBridgeTest() {
        //given
        OutputView outputView = new OutputView();
        String expectedValue = "[";

        //when
        String actualValue = outputView.initBottomBridge().toString();

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("게임 결과에 대한 출력에서 마지막 '|' 제거하고 ']'로 닫은 문자열이 반환되어야 한다.")
    @Test
    public void closeTopBridgeTest() {
        //given
        OutputView outputView = new OutputView();
        StringBuilder testResult = new StringBuilder();
        testResult.append("[ O | O | O |");
        String expectedValue = "[ O | O | O ]";

        //when
        String actualValue = outputView.closeTopBridge(testResult);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("게임 결과에 대한 출력에서 마지막 '|' 제거하고 ']'로 닫은 문자열이 반환되어야 한다.")
    @Test
    public void closeBottomBridgeTest() {
        //given
        OutputView outputView = new OutputView();
        StringBuilder testResult = new StringBuilder();
        testResult.append("[ O | O | O |");
        String expectedValue = "[ O | O | O ]";

        //when
        String actualValue = outputView.closeBottomBridge(testResult);

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("사용자 입력과 실제 생성된 다리의 비교 값이 String 형태로 반환되어야 한다.")
    @Test
    public void printTopBridgeStatusTest() {
        //given
        BridgeGame game = new BridgeGame();
        OutputView outputView = new OutputView();
        game.bridge = Arrays.asList("U", "D", "D");
        game.userInput = Arrays.asList("U", "D");
        StringBuilder testStringBuilder = new StringBuilder();
        testStringBuilder.append("[");
        String expectedValue = "[ O |   |";

        //when
        String actualValue = outputView.printTopBridgeStatus(game, testStringBuilder).toString();

        //then
        assertEquals(expectedValue, actualValue);
    }

    @DisplayName("사용자 입력과 실제 생성된 다리의 비교 값이 String 형태로 반환되어야 한다.")
    @Test
    public void printBottomBridgeStatusTest() {
        //given
        BridgeGame game = new BridgeGame();
        OutputView outputView = new OutputView();
        game.bridge = Arrays.asList("U", "D", "D");
        game.userInput = Arrays.asList("U", "D");
        StringBuilder testStringBuilder = new StringBuilder();
        testStringBuilder.append("[");
        String expectedValue = "[   | O |";

        //when
        String actualValue = outputView.printBottomBridgeStatus(game, testStringBuilder).toString();

        //then
        assertEquals(expectedValue, actualValue);
    }
}
