package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgePainterTest {
    BridgePainter bridgePainter = new BridgePainter();
    List bridge = List.of("U", "D", "U", "U", "D");

    @Test
    @DisplayName("현재까지의 다리 출력")
    void paint(){
        bridgePainter.paint(bridge, 3, true);
        System.out.println(bridgePainter);
    }

    @Test
    @DisplayName("이전 다리 + 현재 다리 결과 O")
    void paint2() {
        bridgePainter.paint(bridge, 4, true);
        System.out.println(bridgePainter);
    }

    @Test
    @DisplayName("이전 다리 + 현재 다리 결과 X")
    void paint3() {
        bridgePainter.paint(bridge, 4, false);
        System.out.println(bridgePainter);
    }
}