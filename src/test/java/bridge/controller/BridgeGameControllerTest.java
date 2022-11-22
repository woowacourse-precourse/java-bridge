package bridge.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameControllerTest {
    private BridgeGameController bridgeGameController;

    public BridgeGameControllerTest() {
        bridgeGameController = new BridgeGameController();
    }

    @DisplayName("다리길이 정상 입력시 정수형으로 리턴.")
    @Test
    void input_Bridge_Size() {
        String inputNumber = "10";
        int answer = 10;
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
        assertEquals(bridgeGameController.getBridgeSize(), answer);
    }

    @DisplayName("다리길이 예외 입력후 정상 입력.")
    @Test
    void input_Bridge_Size_Error_After_Collect() {
        String inputNumberError = "21";
        String inputNumber = "20";
        int answer = 20;
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
        assertEquals(bridgeGameController.getBridgeSize(), answer);
    }

    @DisplayName("이동 하는칸 정상 입력시 값 리턴.")
    @Test
    void input_Move() {
        String inputMove = "U";
        System.setIn(new ByteArrayInputStream(inputMove.getBytes()));
        assertEquals(bridgeGameController.getMove(), inputMove);
    }

    @DisplayName("이동 하는칸 예외 입력후 정상 입력.")
    @Test
    void input_Move_Error_After_Collect() {
        String inputError = "21";
        String inputMove = "U";
        System.setIn(new ByteArrayInputStream(inputError.getBytes()));
        System.setIn(new ByteArrayInputStream(inputMove.getBytes()));
        assertEquals(bridgeGameController.getMove(), inputMove);
    }
    
}