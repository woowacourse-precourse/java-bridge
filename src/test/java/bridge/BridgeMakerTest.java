package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("다리가 U 또는 D로 잘 생성되는지 테스트")
    @Test
    void makeBridgeTest(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(5);
        for(String each : bridge){
            assertEquals(true, isUorD(each));
        }
    }

    private boolean isUorD(String input){
        if(input.equals("U") || input.equals("D")){
            return true;
        }
        return false;
    }

}