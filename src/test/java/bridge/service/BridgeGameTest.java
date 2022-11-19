package bridge.service;

import bridge.model.entity.Bridge;
import bridge.model.entity.BridgeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    public void beforeEach() {
        bridgeGame = new BridgeGame();
        List<String> answer = List.of("U", "D", "U", "D");
        bridgeGame.createBridge(answer);
        bridgeGame.createBridgeMap();

    }

    @DisplayName("CreateBridge 테스트 ")
    @Test
    void createBridge() {
        //Given
        int except = 4;
        Bridge bridge = bridgeGame.getBridge();

        //When

        //Then
        assertThat(bridge.getAnswer().size()).isEqualTo(except);
    }

    @DisplayName("createBridgeMap 테스트")
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

    @DisplayName("move 테스트")
    @ParameterizedTest
    @CsvSource(value = {"U:O:1"}, delimiter = ':')
    void move(String direction, String result, int expectSize) {
        //Given

        //When
        bridgeGame.move(direction);
        String answer = bridgeGame.getBridgeMap().getUpMap().get(0);
        int size = bridgeGame.getBridgeMap().getUpMap().size();

        //Then
        assertThat(answer).isEqualTo(result);
        assertThat(size).isEqualTo(expectSize);
    }


    @DisplayName("checkMove 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:U", "0:D"}, delimiter=':')
    void checkMove(int inputIndex, String direction) {
        //Given
        int startIndex = bridgeGame.getBridgeMap().getIndex();

        //When
        bridgeGame.checkMove(inputIndex, direction);
        int updateIndex = bridgeGame.getBridgeMap().getIndex();

        //Then
        assertThat(startIndex).isEqualTo(updateIndex - 1);
    }

    @DisplayName("addMatchMap 테스트")
    @Test
    void addMatchMap() {
        //Given
        int bridgeSize = bridgeGame.getBridgeMap().getUpMap().size();
        String expectState = "O";
        String move = "U";

        //When
        bridgeGame.addMatchMap(move);
        int updateBridgeSize = bridgeGame.getBridgeMap().getUpMap().size();

        //Then
        assertThat(bridgeSize).isEqualTo(updateBridgeSize - 1);
        assertThat(bridgeGame.getBridgeMap().getUpMap().get(0)).isEqualTo(expectState);
    }

    @DisplayName("addNotMatchMap 테스트")
    @Test
    void addNotMatchMap() {
        //Given
        int bridgeSize = bridgeGame.getBridgeMap().getUpMap().size();
        String expectState = "X";
        String move = "U";

        //When
        bridgeGame.addNotMatchMap(move);
        int updateBridgeSize = bridgeGame.getBridgeMap().getUpMap().size();

        //Then
        assertThat(bridgeSize).isEqualTo(updateBridgeSize - 1);
        assertThat(bridgeGame.getBridgeMap().getUpMap().get(0)).isEqualTo(expectState);
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