package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RealTimeBridgeTest {

    private final RealTimeBridge realTimeBridge = new RealTimeBridge();
    private final String[][] realTimeMap = realTimeBridge.getMap();


    @DisplayName("사용자가 U를 입력하고 정답일 경우 테스트")
    @Test
    void chooseUpperIsCorrect() {
        String test = "U";
        for(int i=0;i<3;i++)
        realTimeBridge.makeCorrectMap(test);
        String[][] testBridge = {{"[", " O | O | O ", "]"}
                , {"[", "   |   |   ", "]"}};
        assertThat(realTimeMap).isDeepEqualTo(testBridge);
    }

    @DisplayName("사용자가 U를 입력하고 오답일 경우 테스트")
    @Test
    void chooseUpperIsWrong() {
        String test = "U";
        for(int i=0;i<3;i++)
            realTimeBridge.makeWrongMap(test);
        String[][] testBridge = {{"[", " X | X | X ", "]"}
                , {"[", "   |   |   ", "]"}};
        assertThat(realTimeMap).isDeepEqualTo(testBridge);
    }

    @DisplayName("사용자가 D를 입력하고 정답일 경우 테스트")
    @Test
    void chooseDownIsCorrect() {
        String test = "D";
        for(int i=0;i<3;i++)
            realTimeBridge.makeCorrectMap(test);
        String[][] testBridge = {{"[", "   |   |   ", "]"},
                {"[", " O | O | O ", "]"}};
        assertThat(realTimeMap).isDeepEqualTo(testBridge);
    }

    @DisplayName("사용자가 D를 입력하고 오답일 경우 테스트")
    @Test
    void chooseDownIsWrong() {
        String test = "D";
        for(int i=0;i<3;i++)
            realTimeBridge.makeWrongMap(test);
        String[][] testBridge = {{"[", "   |   |   ", "]"},
                {"[", " X | X | X ", "]"}};
        assertThat(realTimeMap).isDeepEqualTo(testBridge);
    }
}
