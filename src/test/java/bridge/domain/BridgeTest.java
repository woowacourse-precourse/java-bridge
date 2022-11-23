package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgeTest {

    @Test
    @DisplayName("Bridge 객체 생성시 다리 사이즈를 입력하면 사이즈에 맞는 리스트를 가진 객체가 생성되어야 한다.")
    void createBridge() throws NoSuchFieldException, IllegalAccessException {
        // given
        int size = 5;

        // when
        Bridge bridge = new Bridge(size);

        // then
        Field shape = Bridge.class.getDeclaredField("shape");
        shape.setAccessible(true);
        List<String> bridgeShape = (List<String>) shape.get(bridge);
        assertEquals(5, bridgeShape.size());
    }

    @Test
    @DisplayName("Bridge 객체에게 현재 구역을 주면 그 구역까지의 리스트를 반환해야한다.")
    void askCurrentShape() {
        // given
        int currentSection = 3;

        // when
        Bridge bridge = new Bridge(20);
        List<String> currentShape = bridge.askCurrentShape(currentSection);

        // then
        assertEquals(3, currentShape.size());
    }
}