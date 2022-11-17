package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
    
    @DisplayName("BridgeDirection의 generate number에 매치되는 select값을 원소로 리스트로 반환한다.")
    @Test
    void makeBridgeByValid() {
        BridgeMaker bridgeMaker = getByNumberList(newArrayList(0, 1, 0, 1, 1));
        
        assertThat(bridgeMaker.makeBridge(5)).isEqualTo(
                List.of(
                        BridgeDirection.DOWN.getSelect(),
                        BridgeDirection.UP.getSelect(),
                        BridgeDirection.DOWN.getSelect(),
                        BridgeDirection.UP.getSelect(),
                        BridgeDirection.UP.getSelect())
        );
    }
    
    BridgeMaker getByNumberList(List<Integer> generateNumberList) {
        return new BridgeMaker(new TestNumberGenerator(generateNumberList));
    }
    
    static class TestNumberGenerator implements BridgeNumberGenerator {
        
        private final List<Integer> numbers;
        
        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }
        
        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
