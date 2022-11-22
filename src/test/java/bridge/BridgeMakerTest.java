package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @DisplayName("메소드 리턴값 테스트")
    @Test
    void generate_test() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        int number = bridgeMaker.generateBridge();
        assertThat(number).isBetween(0, 1);
    }
    @DisplayName("숫자에따라 UD추가하는 메소드 테스트")
    @Test
    void addBridge_test(){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator=new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> Bridge=new ArrayList<>();
        bridgeMaker.addBridge(Bridge,1);
        assertThat(Bridge.size()==1&&(Bridge.contains("U")));
    }

    @DisplayName("다리를 만드는 메소드 테스트")
    @Test
    void makeBridge_test(){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator=new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> Bridge=new ArrayList<>();
        Bridge=bridgeMaker.makeBridge(4);
        assertThat(Bridge.size()==4&&(Bridge.contains("U"))||Bridge.contains("D"));

    }
}