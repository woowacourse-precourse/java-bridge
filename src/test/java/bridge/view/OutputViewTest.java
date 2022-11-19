package bridge.view;

import bridge.constant.GameStatus;
import bridge.model.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @DisplayName("맵이 프린트 되는 형식을 눈으로 확인하기 위한 테스트(게임에 실패한 경우)")
    @Test
    void printMapTestForFailCase() {
        Bridge bridge = new Bridge(5);
        OutputView outputView = new OutputView();
        outputView.printMap(bridge, 2, GameStatus.FAIL);
    }

    @DisplayName("맵이 프린트 되는 형식을 눈으로 확인하기 위한 테스트(게임을 클리어한 경우)")
    @Test
    void printMapTestForSuccessCase() {
        Bridge bridge = new Bridge(6);
        OutputView outputView = new OutputView();
        outputView.printMap(bridge, 5, GameStatus.SUCCESS);
    }
}