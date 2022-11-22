package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    @DisplayName("생성자 인수로 숫자 변경이 안 되는 문자열에 대한 예외처리")
    @Test
    void 다리_생성자1(){
        Assertions.assertThatThrownBy(()->
                new Bridge("문자열")
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings ={"2","21"})
    @DisplayName("다리의 최대 최소 길이 범위 바깥에 있는")
    @Test
    void 다리_생성자2(String string){
        Assertions.assertThatThrownBy(()->
                new Bridge(string)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 숫자 확인")
    @Test
    void 다리_생성자3(){
        Bridge bridge = new Bridge("3");
        for(int i = 0; i<bridge.getBridgeCanCross().size(); i++){
            assertTrue(bridge.getBridgeCanCross().get(i) ==UserCommand.MOVE_UP.getCommand()
                    ||bridge.getBridgeCanCross().get(i)==UserCommand.MOVE_DOWN.getCommand());
        }
    }

    @DisplayName("다리 초기화 확인")
    @Test
    void 다리_초기화(){
        Bridge bridge = new Bridge("3");
        List<String> testBridgeUnit = Arrays.asList(" "," "," ");
        List<String> bridgeUnit = bridge.getBridgeMap().get("U");
        Assertions.assertThat(testBridgeUnit).isEqualTo(bridgeUnit);
        bridgeUnit = bridge.getBridgeMap().get("D");
        Assertions.assertThat(testBridgeUnit).isEqualTo(bridgeUnit);
    }

    @DisplayName("다리 특정 자리 변경")
    @Test
    void bridgeUnit_change(){
        Bridge bridge = new Bridge("3");
        List<String> testBridgeUnit = Arrays.asList(" ","X"," ");
        bridge.changeBridgeMap(1,"U","X");
        Assertions.assertThat(testBridgeUnit).isEqualTo(bridge.getBridgeMap().get("U"));
        Assertions.assertThat(testBridgeUnit).isNotEqualTo(bridge.getBridgeMap().get("D"));
    }
}