package bridge;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    private static BridgeMaker bridgeMaker;
    @BeforeAll
    static void init(){
        bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1,0,1,0,1,0)));
    }

    @Test
    void makeBridge_기능_테스트() {
        //given
        int size = 3;
        //when
        List<String> result = bridgeMaker.makeBridge(size);
        //then
        assertEquals(List.of("U","D","U"),result);
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