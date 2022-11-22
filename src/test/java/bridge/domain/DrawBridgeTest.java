package bridge.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DrawBridgeTest extends NsTest {

    private DrawBridge drawBridge;

    @BeforeEach
    void setUp() {
        drawBridge = new DrawBridge();
    }

    @Test
    void draw() {
        drawBridge.draw("U", true);
        drawBridge.draw("U", false);
        drawBridge.draw("D", true);
        drawBridge.draw("D", false);
        assertThat(drawBridge.printBridge()).isEqualTo(
                "[ O | X |   |   ]\n[   |   | O | X ]"
        );
    }

    @AfterEach
    void resetTest() {
        drawBridge.reset();
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
