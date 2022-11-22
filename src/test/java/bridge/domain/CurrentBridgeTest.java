package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CurrentBridgeTest {

    CurrentBridge currentBridge;

    @BeforeEach
    void clear() {
        this.currentBridge = new CurrentBridge();
    }

    @Test
    @DisplayName("CurrentBridge는 현재 구역을 까지의 위구역과 아래구역을 가지고 있어야 한다.")
    void currentBridgeHaveCurrentShape() {
        // given
        List<String> currentShape1 = List.of("U");
        List<String> currentShape2 = List.of("U", "D");
        List<String> currentShape3 = List.of("U", "D", "U");

        // when
        currentBridge.setSection(currentShape1, "U");
        currentBridge.setSection(currentShape2, "D");
        currentBridge.setSection(currentShape3, "U");

        // then
        assertEquals(List.of("O", " ", "O"), currentBridge.getUpperSection());
        assertEquals(List.of(" ", "O", " "), currentBridge.getLowerSection());
    }

    @Test
    @DisplayName("CurrentBridge는 입력값과 다리의 구역이 틀리면 X를 포함한 리스트를 반환 해야한다.")
    void currentBridgeHaveX() {
        // given
        List<String> currentShape1 = List.of("U");
        List<String> currentShape2 = List.of("U", "D");
        List<String> currentShape3 = List.of("U", "D", "U");

        // when
        currentBridge.setSection(currentShape1, "U");
        currentBridge.setSection(currentShape2, "D");
        currentBridge.setSection(currentShape3, "D");

        // then
        assertEquals(List.of("O", " ", " "), currentBridge.getUpperSection());
        assertEquals(List.of(" ", "O", "X"), currentBridge.getLowerSection());
    }

    @Test
    @DisplayName("isSuccessLastSection 메서드는 마지막 구역이 O이면 true를 리턴한다.")
    void lastSectionOTrue() {
        // given
        List<String> currentShape = List.of("U", "D", "U");

        // when
        currentBridge.setSection(currentShape, "U");
        boolean successLastSection = currentBridge.isSuccessLastSection();

        // then
        assertTrue(successLastSection);
    }

    @Test
    @DisplayName("isSuccessLastSection 메서드는 마지막 구역이 X이면 false를 리턴한다.")
    void lastSectionXFalse() {
        // given
        List<String> currentShape = List.of("U", "D", "U");

        // when
        currentBridge.setSection(currentShape, "D");
        boolean successLastSection = currentBridge.isSuccessLastSection();

        // then
        assertFalse(successLastSection);
    }
}