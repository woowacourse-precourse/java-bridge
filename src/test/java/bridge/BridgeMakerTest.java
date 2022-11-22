package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

class BridgeMakerTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @ValueSource(strings = {"3", "4", "5", "10", "19", "20"})
    @ParameterizedTest
    void 다리를_만든다(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);

        int result = bridge.size();
        int expect = size;

        assertThat(result).isEqualTo(expect);
    }

    @ValueSource(strings = {"3", "4", "10", "15", "19", "20"})
    @ParameterizedTest
    void 다리의_길이를_입력받고_유효성_검사를_한_후_정수_형태로_반환한다(String input) {
        int expected = Integer.parseInt(input);

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = bridgeMaker.takeBridgeSize();

        assertThat(result).isEqualTo(expected);
    }

    @ValueSource(strings = {"A", "bb", "@$%", "ABC", "가나다", "RRRR", "1234", "-1", "0", "1", "30"})
    @EmptySource
    @ParameterizedTest
    void 다리의_길이를_입력받고_유효성_검사했을_때_이상이_있을_경우_예외처리한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            bridgeMaker.takeBridgeSize();

            assertThat(outputStream.toString()).contains("[ERROR]");
        } catch (NoSuchElementException ignore) {
        }
    }

    @ValueSource(strings = {"3", "4", "5", "10", "20"})
    @ParameterizedTest
    void 주어진_길이의_랜덤_다리를_만든다(int bridgeSize) {
        List<Integer> bridgeRandomNumbers = bridgeMaker.makeBridgeRandomNumbers(bridgeNumberGenerator, bridgeSize);

        assertThat(bridgeRandomNumbers.size()).isEqualTo(bridgeSize);
    }

    @CsvSource(value = {
            "D,U,U,D,U,U : 0,1,1,0,1,1",
            "D,D,D,D,D,D,D,D,D : 0,0,0,0,0,0,0,0,0",
            "D,U,D : 0,1,0",
            "U,U,U,U,U : 1,1,1,1,1",
            "D,D,D,D,D,U,U,U,U : 0,0,0,0,0,1,1,1,1"
    }, delimiter = ':')
    @ParameterizedTest
    void U와_D로_이루어진_다리를_만든다(String expectedUdShapedBridgeInput, String bridgeRandomNumbersInput) {
        List<String> expectedUdShapedBridge = Arrays.stream(expectedUdShapedBridgeInput.split(","))
                .collect(Collectors.toList());

        List<Integer> bridgeRandomNumbers = Arrays.stream(bridgeRandomNumbersInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> result = bridgeMaker.makeUdShapedBridge(bridgeRandomNumbers);

        assertThat(result).isEqualTo(expectedUdShapedBridge);
    }

    @CsvSource(value = {
            "0 : D",
            "1 : U"
    }, delimiter = ':')
    @ParameterizedTest
    void 랜덤_수에_따라_U_또는_D로_변환한다(int position, String expected) {
        String result = bridgeMaker.makeUdShapedRandomStateOfOneLine(position);

        assertThat(result).isEqualTo(expected);
    }
}