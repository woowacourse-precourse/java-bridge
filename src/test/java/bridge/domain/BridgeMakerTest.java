package bridge.domain;


import static org.junit.jupiter.api.Assertions.*;
import bridge.FrontController;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    FrontController frontController;

    int size;

    @BeforeEach
    void setUp() {

        frontController = new FrontController();

    }

    @Test
    public void 랜덤수에_따른_칸을_표현() throws Exception{
        //given
        size = 3;
        List<String> bridge = frontController.bridgeRepository();
        List<String> assertBridge = new ArrayList<>();

        //when
        assertBridge.add("U");
        assertBridge.add("D");
        assertBridge.add("U");

        //then
        assertEquals(assertBridge, bridge);
    }

    @Test
    public void 다리_생성() throws Exception{
        //given
        List<String> bridge = frontController.bridgeRepository();
        List<String> assertBridge = new ArrayList<>();

        //when

        //then
        assertEquals(assertBridge, bridge);
    }

    @DisplayName("다리 길이 생성의 규칙 검증")
    @Test
    void assertBridgeSize(){
        // given
        String bridgeFirst = "[ O ]";
        LinkedList<String> bridge = new LinkedList<>();

        int bridgeFirstSize= 5;
        // 다리 길이는 5부터 (n-1)*4씩 증가
        int bridgeParameter = 3;
        int bridgeAnyParameter = 12;
        int bridgeParameterMax = 20;

        int bridgeSize = bridgeFirstSize+(bridgeParameter-1)*4;
        int bridgeSomeSize = bridgeFirstSize+(bridgeAnyParameter-1)*4;
        int bridgeMaxSize = bridgeFirstSize+(bridgeParameterMax-1)*4;

        assertEquals(13, bridgeSize);
        assertEquals(49, bridgeSomeSize);
        assertEquals(81, bridgeMaxSize);

    }

    @Test
    public void 이중_for문() throws Exception{
        ArrayList<String> bridge = new ArrayList<>();

    }

}