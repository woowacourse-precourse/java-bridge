package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("move를 사용했을 때 move 횟수와 index가 일치하는가?")
    @Test
    void indexMoveTest() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        //when
        for(int i = 0; i < 5; i++){
            bridgeGame.move();
        }
        //then
        assertThat(bridgeGame.getIndex()).isEqualTo(5);
    }

    @DisplayName("R과 Q를 입력했을 때 재시작 여부 리턴값이 잘 나오는가")
    @Test
    void retryTest() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        //when
        String retry = "R";
        String quit = "Q";
        //then
        assertThat(bridgeGame.retry(retry)).isTrue();
        assertThat(bridgeGame.retry(quit)).isFalse();
    }

    @DisplayName("다리 배열과 input, index 가 주어졌을 때 return value 확인")
    @Test
    void checkStatusTest() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = new ArrayList<>(List.of("U", "D", "D", "U", "U"));
        //when
        String input = "U";
        int index = 2;
        //then
        assertThat(bridgeGame.checkStatus(bridge, input, index)).isFalse();
    }
    
}