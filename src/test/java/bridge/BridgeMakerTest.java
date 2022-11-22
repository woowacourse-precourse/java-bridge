package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.model.BridgeMaker;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


@DisplayName("BridgeMaker 클래스")
@Nested
class BridgeMakerTest {

    @DisplayName("createShape 메소드는")
    @Nested
    class Describe_make {

        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(List.of(1, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);

        @DisplayName("0또는 1을 입력받아 다리의 모양으로(U,D) 리턴한다.")
        @CsvSource({"1,U", "0,D"})
        @ParameterizedTest
        void createShapeTest(String input, String output) {
            assertEquals(output, bridgeMaker.createShape(Integer.parseInt(input)));
        }
    }

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