package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.code.BridgeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMapTest {

    @Test
    @DisplayName("1 입력시 U출력")
    void getCREATEResultString_1(){
        assertThat(BridgeMap.FOR_CREATE.getString(1)).contains("U");
    }


    @Test
    @DisplayName("0 입력시 D출력")
    void getCREATEResultString_2(){
        assertThat(BridgeMap.FOR_CREATE.getString(0)).contains("D");
    }

    @Test
    @DisplayName("true 입력시 O출력")
    void getMOVEResultString_1(){
        assertThat(BridgeMap.FOR_MOVE.getString(true)).contains("O");
    }

    @Test
    @DisplayName("false 입력시 X출력")
    void getMOVEResultString_2(){
        assertThat(BridgeMap.FOR_MOVE.getString(false)).contains("X");
    }


    @Test
    @DisplayName("true 입력시 성공 출력")
    void getTOTALResultString_1(){
        assertThat(BridgeMap.FOR_TOTAL.getString(true)).contains("성공");
    }

    @Test
    @DisplayName("false 입력시 실패 출력")
    void getTOTALResultString_2(){
        assertThat(BridgeMap.FOR_TOTAL.getString(false)).contains("실패");
    }


}
