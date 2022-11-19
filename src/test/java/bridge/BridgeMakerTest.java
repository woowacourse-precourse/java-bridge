package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    private BridgeNumberGenerator bridgeNumberGenerator;
    @Test
    @DisplayName("다리 만들기 기능 테스트 - 성공 ")
    public void makeBridge() throws Exception{
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        int size = 5;
        List<String> bridge = new ArrayList<>();
        List<Integer> generateNumber = new ArrayList<>();
        while(size != 0){
            int uNd = bridgeNumberGenerator.generate();
            generateNumber.add(uNd);
            if(uNd == 1)
                bridge.add("U");
            else
                bridge.add("D");
            size -=1;
        }
        for(int i = 0;i<generateNumber.size();i++){
            if(generateNumber.get(i) == 1 )
                Assertions.assertThat(bridge.get(i)).isEqualTo("U");
            else
                Assertions.assertThat(bridge.get(i)).isEqualTo("D");
        }
    }
}