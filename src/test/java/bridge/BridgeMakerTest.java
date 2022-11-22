package bridge;

import bridge.mokup.TestBridgeNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

public class BridgeMakerTest {
    static BridgeNumberGenerator getGenerator() { return new TestBridgeNumberGenerator(1);}
    static BridgeNumberGenerator getGenerator2(){ return new TestBridgeNumberGenerator(0);}

    @ParameterizedTest(name="생성테스트 {index} : {2}")
    @MethodSource
    void creationTest(BridgeNumberGenerator gen, int size, List<String> expected){
        BridgeMaker bm = new BridgeMaker(gen);
        assertThat(bm.makeBridge(size)).isEqualTo(expected);
    }

    static Stream<Arguments> creationTest(){
        return Stream.of(
                Arguments.arguments(getGenerator(), 4, List.of("D","U","D","U")),
                Arguments.arguments(getGenerator(), 3, List.of("D","U","D")),
                Arguments.arguments(getGenerator2(), 4, List.of("U","D","U","D")),
                Arguments.arguments(getGenerator2(), 3, List.of("U","D","U"))
                );
    }

}
