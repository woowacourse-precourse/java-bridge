package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    private final BridgeMaker bridgeMaker  = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final List<String> bridge = bridgeMaker.makeBridge(5);

    @Test
    public void 사이즈_확인(){
        assertEquals(5, bridge.size());
    }

    @Test
    public void 브릿지_원소_확인(){
        int uCount = 0;
        int dCount = 0;
        for(String element: bridge){
            if(element.equals("U")) uCount++;
            if(element.equals("D")) uCount++;
        }
        assertEquals(bridge.size(), uCount + dCount);
    }

}