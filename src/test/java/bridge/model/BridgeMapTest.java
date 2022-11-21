package bridge.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMapTest {

    private BridgeMap bridgeMap;

    @BeforeEach
    void setUp(){
        bridgeMap = BridgeMap.createBridgeMap(6);
    }

    @DisplayName("이동한 곳에 해당 위칸 다리를 만들 수 있다.")
    @Test
    void makeUpBridgeMoving(){
        //given
        int location=2;
        String expression="O";
        String expectedResult = "O";

        //when
        bridgeMap.makeBridgeUpMap(location,expression);
        List<String> bridgeUpMap = bridgeMap.getBridgeUpMap();
        String result = bridgeUpMap.get(location);

        //then
        assertEquals(expectedResult,result);
    }

    @DisplayName("이동한 곳에 해당 아래칸 다리를 만드는 기능 테스트.")
    @Test
    void makeDownBridgeMoving(){
        //given
        int location=2;
        String expression="X";
        String expectedResult = "X";

        //when
        bridgeMap.makeBridgeUpMap(location,expression);
        List<String> bridgeUpMap = bridgeMap.getBridgeUpMap();
        String result = bridgeUpMap.get(location);

        //then
        assertEquals(expectedResult,result);
    }

    @DisplayName("위칸 다리 만들기 테스트")
    @Test
    void makeUpBridge(){
        //given
        String expression = "O";
        String expression1 = "O";
        String expression2 = "X";
        int location=0;
        int location1=1;
        int location2=2;
        String moving = "U";

        //when
        bridgeMap.makeBridgeMap(location,moving,expression);
        bridgeMap.makeBridgeMap(location1,moving,expression1);
        bridgeMap.makeBridgeMap(location2,moving,expression2);
        List<String> result = bridgeMap.getBridgeUpMap();

        //then
        assertThat(result).containsSequence("O", "O", "X");
    }

    @DisplayName("아래칸 다리 만들기 테스트")
    @Test
    void makeDownBridge(){
        //given
        String expression = "O";
        String expression1 = "O";
        String expression2 = "X";
        int location=0;
        int location1=1;
        int location2=2;
        String moving = "D";

        //when
        bridgeMap.makeBridgeMap(location,moving,expression);
        bridgeMap.makeBridgeMap(location1,moving,expression1);
        bridgeMap.makeBridgeMap(location2,moving,expression2);
        List<String> result = bridgeMap.getBridgeDownMap();

        //then
        assertThat(result).containsSequence("O", "O", "X");
    }
}
