package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class BridgeMakerTest {

    //올바른 사이즈, 문자열의 결과를 생성했는지
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    void makeBridgeTest(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> result = bridgeMaker.makeBridge(size);
        assertThat(result.size()).isEqualTo(size);
        assertThat(result).allMatch(str -> str.equals("U") || str.equals("D"));
    }
}
