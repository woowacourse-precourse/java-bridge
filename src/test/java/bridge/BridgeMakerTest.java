package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {
    private static BridgeMaker bridgeMaker;

    @DisplayName("생성된 칸들은 U나 D뿐이다")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    void makeResult(int size) {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Set<String> generatedMovableSpaces = new HashSet<>(bridgeMaker.makeBridge(size));
        generatedMovableSpaces.remove("U");
        generatedMovableSpaces.remove("D");

        assertThat(generatedMovableSpaces).isEmpty();
    }
}
