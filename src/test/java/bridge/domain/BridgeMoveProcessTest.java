package bridge.domain;

import bridge.constant.GameState;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BridgeMoveProcessTest{

    @Test
    @DisplayName("사용자의 다리를 그리는 과정에서 잘 그렸는지 확인")
    void makeUserBridge(){
        List<Boolean> upState = List.of(true, true, false);
        List<Boolean> downState = List.of(false, false, true);
        BridgePrinting bridgePrinting = new BridgePrinting(upState, downState);
        bridgePrinting.addTraceLocation(GameState.UP_STATEMENT);
        bridgePrinting.addTraceLocation(GameState.UP_STATEMENT);
        bridgePrinting.addTraceLocation(GameState.DOWN_STATEMENT);
        bridgePrinting.makeBridge();
        Assertions.assertThat(bridgePrinting.getSize()).isEqualTo(3);
    }


    @Test
    @DisplayName("위, 아래 다리의 상태를 받아오고 변환하는 과정 - 위 칸을 지나갈 수 있는 경우")
    void setPrintState_State_UP(){
        int getState = GameState.UP_STATEMENT;
        List<Boolean> upState = new ArrayList<>();
        List<Boolean> downState = new ArrayList<>();
        if (getState == GameState.UP_STATEMENT) {
            upState.add(true);
            downState.add(false);
        }
        Assertions.assertThat(upState.get(0)).isEqualTo(true);
    }

    @Test
    @DisplayName("위, 아래 다리의 상태를 받아오고 변환하는 과정 - 아래 칸을 지나갈 수 있는 경우")
    void setPrintState_State_DOWN(){
        int getState = GameState.DOWN_STATEMENT;
        List<Boolean> upState = new ArrayList<>();
        List<Boolean> downState = new ArrayList<>();
        if (getState == GameState.DOWN_STATEMENT) {
            upState.add(false);
            downState.add(true);
        }
        Assertions.assertThat(downState.get(0)).isEqualTo(true);
    }

}
