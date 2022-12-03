package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BridgeMakerTest {

    private BridgeNumberGenerator bridgeNumberGenerator;
    @Test
    @DisplayName("다리 만들기 기능 테스트 - 성공 ")
    public void makeBridge() throws Exception{
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        int size = 5;
        List<String> bridge = new ArrayList<>();
        List<Integer> generateNumbers = new ArrayList<>();
        while(size != 0){
            bridge.add(generate(generateNumbers));
            size -=1;
        }
        for(int i = 0 ;i<generateNumbers.size();i++){
            isCorrect(generateNumbers.get(i), bridge.get(i));
        }
    }
    private void isCorrect(Integer value , String uNd){
        if(value == 1)Assertions.assertThat(uNd).isEqualTo("U");
        if(value == 0)Assertions.assertThat(uNd).isEqualTo("D");
    }
    private String generate(List<Integer> generateNumbers){
        if(bridgeNumberGenerator.generate() == 1) {
            generateNumbers.add(1);
            return "U";
        }
        generateNumbers.add(0);
        return "D";
    }




}