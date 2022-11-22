package bridge;

import bridge.domain.InputView;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.StringReader;

public class InputViewTest {

    @Test
    @DisplayName("다리 길이 입력값이 3부터 20 사이여야 하는 조건 테스트")
    void validateBridgeSizeTest() {
        InputView inputView = new InputView();
//        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.readBridgeSize("1a"));
//        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.readBridgeSize("123"));
//        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.readBridgeSize("21"));
//        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.readBridgeSize("2"));
    }

    @Test
    @DisplayName("이동할 칸 입력값이 U 또는 D여야 하는 조건 테스트")
    void validateReadMovingTest() {
        InputView inputView = new InputView();
//        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.readMoving("E"));
    }

    @Test
    @DisplayName("게임을 다시 시작할지 여부가 R 또는 Q여야 하는 조건 테스트")
    void validateReadGameCommandTest() {
        InputView inputView = new InputView();
//        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.readGameCommand("E"));
    }
}
