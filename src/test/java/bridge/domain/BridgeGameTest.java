package bridge.domain;

import bridge.BridgeGame;
import bridge.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest{
    private static final int BRIDGE_SIZE=5;
    private static final List<String> BRIDGE=List.of("U", "D", "U", "D", "U");
    private static final List<String> MOVING_RESULT=List.of(Constants.CORRECT, Constants.WRONG);
    private static final int TRY_COUNT=2;
    private static final int RESULT_UP_LIST_RESET_SIZE=0;
    BridgeGame bridgeGame;
    @BeforeEach
    void setup(){
        bridgeGame=new BridgeGame();
    }
    @Test
    @DisplayName("bridgeSize만큼 다리를 잘 생성하는지 확인")
    void makeBridge(){
        bridgeGame.makeBridge(BRIDGE);
        assertThat(bridgeGame.getBridgeSize()).isEqualTo(BRIDGE_SIZE);
    }
    @Test
    @DisplayName("입력한 이동이 정답이면 O를 오답이면 X를 반환하는지 확인")
    void move(){
        bridgeGame.makeBridge(BRIDGE);
        assertThat(bridgeGame.move(0, Constants.MOVE_UP)).isEqualTo(Constants.CORRECT);
        assertThat(bridgeGame.move(0, Constants.MOVE_DOWN)).isEqualTo(Constants.WRONG);
    }
    @Test
    @DisplayName("재시도하면 결과 리스트가 초기화되고 시도횟수가 2로 증가하는지 확인")
    void retry(){
        bridgeGame.retry();
        assertThat(bridgeGame.getResult().get(0).size()).isEqualTo(RESULT_UP_LIST_RESET_SIZE);
        assertThat(bridgeGame.getTryCount()).isEqualTo(TRY_COUNT);
    }
}