package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("BridgeMaker 클래스")
@Nested
class BridgeMakerTest {

    @DisplayName("makeBridge 메소드는")
    @Nested
    class Describe_makeBridge {

        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(
                newArrayList(1, 1, 0, 0, 1, 0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);

        @DisplayName("생성할 다리의 길이를 입력 받아 임의의 다리 배열을 리턴한다.")
        @Test
        void createShapeTest() {
            assertThat(bridgeMaker.makeBridge(8)).isEqualTo(
                    List.of("U", "U", "D", "D", "U", "D", "U", "D"));
        }
    }
}