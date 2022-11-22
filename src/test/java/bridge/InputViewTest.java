package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private static InputView inputView;

    @BeforeAll
    static void initAll() {
        inputView = new InputView();
    }

    @Test()
    void 다리_길이_영문_입력_오류_테스트() {
        String input = "K";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(IllegalArgumentException.class, () -> inputView.readBridgeSize());
    }

    @Test()
    void 다리_길이_오류_테스트() {
        String input = "21";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(IllegalArgumentException.class, () -> inputView.readBridgeSize());
    }

    @Test()
    void 다리_길이_정상_테스트() {
        String input = "20";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertDoesNotThrow(() -> inputView.readBridgeSize());
    }
}