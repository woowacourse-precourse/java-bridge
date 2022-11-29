package bridge.domain;

import bridge.constant.GameState;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgePrintingCoreTest {

    @Test
    @DisplayName("올바른 칸을 건너갔는지 검증하는 조건 test")
    void isRightStep() {
        List<Boolean> bridgeState = List.of(true, true, false);
        List<Integer> traceLocation = List.of(GameState.UP_STATEMENT,GameState.DOWN_STATEMENT,GameState.DOWN_STATEMENT);
        int nowState=GameState.DOWN_STATEMENT;
        String state = null;
        int index=1;
        if(bridgeState.get(index) && traceLocation.get(index) == nowState){
           state = GameState.EXIST_SQUARE;
        }
        Assertions.assertThat(state).isEqualTo(GameState.EXIST_SQUARE);
    }

    @Test
    @DisplayName("올바르지 못한 칸을 건넜을때 X 반환 검증하는 조건 test")
    void isWrongStep() {
        List<Boolean> bridgeState = List.of(true, false, false);
        List<Integer> traceLocation = List.of(GameState.UP_STATEMENT,GameState.DOWN_STATEMENT,GameState.DOWN_STATEMENT);
        String state = null;
        int index=1;
        int nowState=GameState.DOWN_STATEMENT;
        if(!bridgeState.get(index) && traceLocation.get(index) == nowState){
            state = GameState.NO_EXIST_SQUARE;
        }
        Assertions.assertThat(state).isEqualTo(GameState.NO_EXIST_SQUARE);
    }

    @Test
    @DisplayName("칸 그림 삽입 시 | 칸 넣는 조건 확인")
    void isIndexBetweenSpace(){
        List<Boolean> bridgeState = List.of(true, false, false);
        int index=2;
        boolean hasNoBetweenSpace=false;
        if (index== bridgeState.size()-1) {
            hasNoBetweenSpace=true;
        }
        Assertions.assertThat(hasNoBetweenSpace).isEqualTo(true);

    }



}