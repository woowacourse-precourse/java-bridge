package bridge.view;

import bridge.model.Bridge;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest extends NsTest {

    @DisplayName("U를 선택했을 때 나오는 다리의 출력값 확인")
    @Test
    void outputViewTest() {
        //given
        OutputView outputView = new OutputView();
        StringBuilder upperBridge = new StringBuilder();
        StringBuilder lowerBridge = new StringBuilder();
        //when
        outputView.WriteInitUpperBridge(upperBridge, lowerBridge, true);
        //then
        outputView.printMap(upperBridge, lowerBridge);
        assertThat(output()).contains(
                "[ O ]",
                "[   ]"
        );
    }

    @DisplayName("다리 2칸 출력값 테스트")
    @Test
    void outputViewTest2() {
        //given
        OutputView outputView = new OutputView();
        StringBuilder upperBridge = Bridge.getUpperBridge();
        StringBuilder lowerBridge = Bridge.getLowerBridge();
        //when
        outputView.WriteInitUpperBridge(upperBridge, lowerBridge, true);
        outputView.WriteUpperBridge(upperBridge, lowerBridge, true);
        //then
        outputView.printMap(upperBridge, lowerBridge);
        assertThat(output()).contains(
                "[ O | O ]",
                "[   |   ]"
        );
    }

    @DisplayName("다리 3칸 출력값 테스트")
    @Test
    void outputViewTest3() {
        //given
        OutputView outputView = new OutputView();
        StringBuilder upperBridge = Bridge.getUpperBridge();
        StringBuilder lowerBridge = Bridge.getLowerBridge();
        //when
        outputView.WriteInitUpperBridge(upperBridge, lowerBridge, true);
        outputView.WriteUpperBridge(upperBridge, lowerBridge, true);
        outputView.WriteLowerBridge(upperBridge, lowerBridge, false);
        //then
        outputView.printMap(upperBridge, lowerBridge);
        assertThat(output()).contains(
                "[ O | O |   ]",
                "[   |   | X ]"
        );
    }

    @Override
    protected void runMain() {

    }
}