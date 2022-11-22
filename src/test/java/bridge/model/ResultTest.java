package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    private final Result result = new Result();

    @ParameterizedTest
    @DisplayName("다리를 건넜는지 여부에 따라 ox 값을 삽입한다.")
    @CsvSource(value = {"U:true:O", "U:false:X", "D:true:O", "D:false:X"}, delimiter = ':' )
    void storeResultBridgesTest(String moving, boolean crossedBridge, String ox) {
        result.storeResultBridges(moving, crossedBridge);

        String resultBridges = result.getResultBridges()
                .replace("[ ", "")
                .replace(" ]", "")
                .replace("\n", "")
                .replace(" ", "");
        assertThat(resultBridges).isEqualTo(ox);
    }
}
