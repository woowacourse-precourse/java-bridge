package bridge;

import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class InputViewTest {
    @Test
    void readBridgeSizeTest() {
        assertSimpleTest(() -> {
            InputView inputView = new InputView();
        });
    }
}
