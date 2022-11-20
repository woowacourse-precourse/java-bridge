package bridge.domain.bridge.maker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeMakerTest {

    @ParameterizedTest
    @CsvSource(value = {"1,0,1,0,1,0:U,D,U,D,U,D"}, delimiterString = ":")
    void bridgeMaker로_U와_D로_구성된_다리를_만들_수_있습니다(final String input, final String result) {
        //new BridgeMaker()
        var numbers = this.convertStringToListNumber(input);
        var expected = this.convertStringToListString(result);

        var bridgeMaker = new BridgeMaker(new BridgeMakerFake(numbers));
        var actual = bridgeMaker.makeBridge(6);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private List<Integer> convertStringToListNumber(final String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> convertStringToListString(final String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }


    class BridgeMakerFake implements BridgeNumberGenerator {
        private final List<Integer> inputs;

        public BridgeMakerFake(List<Integer> inputs) {
            this.inputs = inputs;
        }

        @Override
        public int generate() {
            return inputs.remove(0);
        }
    }
}