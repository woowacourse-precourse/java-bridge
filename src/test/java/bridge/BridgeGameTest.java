package bridge;

import domain.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    private final static int size = 20;

    @Test
    @DisplayName("이동시 결과 값 데이터 추가 확인")
    public void 이동_결과_데이터_사이즈_확인() throws Exception {
        //given
        Bridge bridge = new Bridge(size);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String input = "U";
        //when
        for (int i = 0; i < size; i++) {
            bridgeGame.move(i, input);
        }
        // then
        assertThat(bridgeGame.getResult().size()).isEqualTo(size);
    }

    @Test
    @DisplayName("종료 시 결과는 False")
    public void 재시작_결과_확인_1() throws Exception {
        //given
        Bridge bridge = new Bridge(size);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String input = "Q";

        //when then
        assertThat(bridgeGame.retry(input)).isFalse();
    }

    @Test
    @DisplayName("재시작 시 결과는 True, result.size 초기화")
    public void 재시작_결과_확인_2() throws Exception {
        //given
        Bridge bridge = new Bridge(size);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String input = "R";

        //when then
        assertThat(bridgeGame.retry(input)).isTrue();
        assertThat(bridgeGame.getResult().size()).isEqualTo(0);
    }
}