package bridge.domain;

import static bridge.BridgeExpression.DOWN;
import static bridge.BridgeExpression.END_POINT;
import static bridge.BridgeExpression.SEPARATOR;
import static bridge.BridgeExpression.START_POINT;
import static bridge.BridgeExpression.UP;
import static org.junit.jupiter.api.Assertions.*;

import bridge.BridgeExpression;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    int size;

    @BeforeEach
    void setUp() {

        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    }

    @Test
    public void 랜덤수에_따른_칸을_표현() throws Exception{
        //given
        size = 3;
        List<String> bridge = bridgeMaker.makeBridge(size);
        List<String> assertBridge = new ArrayList<>();


        //when
        int random = Randoms.pickNumberInRange(0, 1);
        for ( int index = 0; index < size; index++ ) {
            assertBridge.add(bridgeMaker.expressionByNumber());
        }


        //then
        assertEquals(assertBridge, bridge);
    }

    @Test
    public void 다리_생성() throws Exception{
        //given
        size = 3;
        List<String> bridge = bridgeMaker.makeBridge(size);
        List<String> assertBridge = new ArrayList<>();

        //when


        //then
        assertEquals(assertBridge, bridge);
    }

    @DisplayName("다리 길이 생성의 규칙을 검증한다.")
    @Test
    void assertBridgeSize(){
        // given
        String bridgeFirst = "[ O ]";
        String bridgeSecond = "[ O | X ]";
        String bridgeThird = "[ O |   | O ]";
        String bridgeFourTh = "[ O |   | O | O ]";
        String bridgeFifth = "[ O | O |   | O | O ]";
        String bridgeSix = "[ O |   | O |   | O | O ]";
        String bridgeThirteen = "[ O | O |   | O | O |   | O | O |   | O |   |   | O ]";

        // 다리 길이는 최소 5부터 4씩 증가, 입력 수 만큼 반복
        assertEquals(bridgeFirst.length(), 5);
        assertEquals(bridgeSecond.length(), 9);
        assertEquals(bridgeThird.length(), 13);
        assertEquals(bridgeFourTh.length(), 17);
        assertEquals(bridgeFifth.length(), 21);
        assertEquals(bridgeSix.length(), 25);
        assertEquals(bridgeThirteen.length(), 53);
    }

}