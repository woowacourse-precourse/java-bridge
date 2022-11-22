package bridge.domain.bridge.maker;

import static bridge.utils.TestUtils.convertStringToListNumber;
import static bridge.utils.TestUtils.convertStringToListString;

import bridge.BridgeMaker;
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
        var numbers = convertStringToListNumber(input);
        var expected = convertStringToListString(result);

        var bridgeMaker = new BridgeMaker(new BridgeMakerFake(numbers));
        var actual = bridgeMaker.makeBridge(6);

        Assertions.assertThat(actual).isEqualTo(expected);
    }


}