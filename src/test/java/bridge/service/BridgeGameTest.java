package bridge.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.Constants.BridgeSign.*;

class BridgeGameTest {

    @DisplayName("이동 테스트")
    @Test
    void moveTest() {
        List<String> bridge = List.of(UP, UP, DOWN);
        List<String> directions = List.of(UP,UP,UP);

        BridgeGame bridgeGame = new BridgeGame();
        List<String> topGameBoard = new ArrayList<>();
        List<String> bottomGameBoard = new ArrayList<>();

        for(int i = 0;i < bridge.size(); i++) {
            String result = bridgeGame.move(bridge.get(i), directions.get(i));

            if (directions.get(i).equals(UP)) {
                topGameBoard.add(result);
                bottomGameBoard.add(EMPTY);
            } else if (directions.get(i).equals(DOWN)) {
                bottomGameBoard.add(result);
                topGameBoard.add(EMPTY);
            }
            if (result.equals(FAIL)){
                break;
            }
        }

        Assertions.assertThat(topGameBoard).isEqualTo(List.of(PASS,PASS,FAIL));
        Assertions.assertThat(bottomGameBoard).isEqualTo(List.of(EMPTY,EMPTY,EMPTY));
    }
}