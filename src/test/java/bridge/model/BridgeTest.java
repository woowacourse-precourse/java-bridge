package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bridge 클래스 단위 테스트")
class BridgeTest {

    Bridge bridge;

    @BeforeEach
    void init() {
        bridge = new Bridge(new ArrayList<>(), new ArrayList<>());
    }

    @Test
    @DisplayName("플레이어가 윗 방향 다리에 올바르게 이동할 경우 위의 다리에 O가 추가된다.")
    void testMoveUpBridgeCorrect() throws Exception {
        //when & then
        bridge.moveUpBridgeCorrect();
        assertEquals(bridge.toString(), "[ O ]" + "\n" + "[   ]");

        bridge.moveUpBridgeCorrect();
        assertEquals(bridge.toString(), "[ O | O ]" + "\n" + "[   |   ]");
    }

    @Test
    @DisplayName("플레이어가 윗 방향 다리에 올바르지 못하게 이동할 경우 위의 다리에 X가 추가된다.")
    void testMoveUpBridgeInCorrect() throws Exception {
        //when
        bridge.moveUpBridgeInCorrect();

        //then
        assertEquals(bridge.toString(), "[ X ]" + "\n" + "[   ]");
    }

    @Test
    @DisplayName("플레이어가 아랫 방향 다리에 올바르게 이동할 경우 아래의 다리에 O가 추가된다.")
    void testMoveDownBridgeCorrect() throws Exception {
        //when & then
        bridge.moveDownBridgeCorrect();
        assertEquals(bridge.toString(), "[   ]" + "\n" + "[ O ]");

        bridge.moveDownBridgeCorrect();
        assertEquals(bridge.toString(), "[   |   ]" + "\n" + "[ O | O ]");
    }
}