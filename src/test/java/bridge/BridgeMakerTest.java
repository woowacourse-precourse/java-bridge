package bridge;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class BridgeMakerTest {

    @Test
    void 랜덤_숫자_생산_테스트(){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

        List<String> bridgeList = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(3);

        assertAll(
                ()->assertEquals(bridgeList.size(),3)
              //()->assertEquals(bridgeList.get(1),1) bridgeList 내부가 1과 0으로 이루어져있는지 refactoring을 통해 확인,
                // 그리고 공통피드백에서 나온 random pick이 테스트하기 어려운 부분을 어떻게 바꿀 수 있는지 고민.
        );

    }




}