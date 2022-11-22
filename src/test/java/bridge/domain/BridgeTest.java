package bridge.domain;

import bridge.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest{
    private static final List<String> TEST_BRIDGE=List.of("U", "D", "U");
    private static final int FIRST_INDEX=0;
    Bridge bridge;

    @BeforeEach
    void setup(){
        bridge=new Bridge(TEST_BRIDGE);
    }
    @Test
    @DisplayName("이동가능한 칸일 때 O를 반환하는지 확인")
    void getMoveResultTrue(){
        assertThat(bridge.getMoveResult(Constants.MOVE_UP, FIRST_INDEX)).isEqualTo(Constants.CORRECT);
    }
    @Test
    @DisplayName("이동 불가능한 칸일 때 X를 반환하는지 확인")
    void getMoveResultFalse(){
        assertThat(bridge.getMoveResult(Constants.MOVE_DOWN, FIRST_INDEX)).isEqualTo(Constants.WRONG);
    }
}