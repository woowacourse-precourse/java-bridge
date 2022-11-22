package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeGameTest {
    @DisplayName("retry함수가 종료 명령이 들어왔을 때 false를 반환하는 지 테스트")
    @Test
    void retry() {
        final BridgeGame bridgeGame = new BridgeGame(3);
        String input = "Q";
        boolean result = bridgeGame.retry(input);
        assertThat(result)
                .isEqualTo(false);
    }

    @DisplayName("canMove함수가 다리와 같은 문자열을 넣었을때 true를 반환하는 지 테스트")
    @Test
    void canMove() {
        final BridgeGame bridgeGame = new BridgeGame(3);
        List<String> move = bridgeGame.getBridge();
        List<String> bridge = bridgeGame.getBridge();
        boolean result = true;
        for(String str : move){
            if(!bridgeGame.canMove(str)){
                result = false;
            }
        }
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("success함수가 다리와 같은 리스트를 넣었을때 true를 반환하는 지 테스트")
    @Test
    void success() {
        final BridgeGame bridgeGame = new BridgeGame(3);
        List<String> move = bridgeGame.getBridge();
        List<String> bridge = bridgeGame.getBridge();
        for(String str : move){
            bridgeGame.canMove(str);
        }
        assertThat(bridgeGame.success()).isEqualTo(true);
    }
}
