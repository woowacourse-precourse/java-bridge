package bridge.service;

import bridge.model.entity.Bridge;
import bridge.model.entity.BridgeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    public void beforeEach() {
        bridgeGame = new BridgeGame();
        bridgeGame.createBridge("5");
        bridgeGame.createBridgeMap();
    }

    @Test
    void createBridge() {
        //Given
        int except = 5;
        bridgeGame.createBridge("5");
        Bridge bridge = bridgeGame.getBridge();

        //When

        //Then
        assertThat(bridge.getAnswer().size()).isEqualTo(except);
    }

    @ParameterizedTest
    @CsvSource(value = {"O:\u0020", "X:\u0020"}, delimiter = ':')
    void createBridgeMap(String input1, String input2) {
        //Given
        int expectSize = 1;
        BridgeMap bridgeMap = bridgeGame.getBridgeMap();
        bridgeMap.add(input1, input2);
        //When

        //Then
        assertThat(bridgeMap.getUpMap().size()).isEqualTo(1);
        assertThat(bridgeMap.getDownMap().size()).isEqualTo(1);
    }

    @Test
    void move() {
    }

    @Test
    void checkMove() {
    }

    @Test
    void addMatchMap() {
    }

    @Test
    void addNotMatchMap() {
    }

    @Test
    void isEnd() {
    }

    @Test
    void success() {
    }

    @Test
    void retry() {
    }
}