package bridge.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeCalculatorTest {

    private BridgeCalculator bridgeCalculator;

    @BeforeEach
    void setUp(){
        bridgeCalculator = new BridgeCalculator();
    }

    @DisplayName("+1 하는 Count 메서드 기능 테스트")
    @Test
    void generateCount(){
        //given
        int num=2;
        int expectedResult=3;

        //when
        int result = bridgeCalculator.countNum(num);

        //then
        assertEquals(expectedResult,result);
    }

    @DisplayName("위치 초기화 기능 테스트")
    @Test
    void generateInitLocation(){
        //given
        int expectedResult=-1;

        //when
        int result = bridgeCalculator.getInitLocation();

        //then
        assertEquals(expectedResult,result);
    }

    @DisplayName("재시도 횟수 초기화 기능 테스트")
    @Test
    void generateInitRetryCount(){
        //given
        int expectedResult=1;

        //when
        int result = bridgeCalculator.getInitRetryCount();

        //then
        assertEquals(expectedResult,result);
    }
}
