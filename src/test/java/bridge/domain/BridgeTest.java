package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class BridgeTest {

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"U,D,U:true", "D,U,D:false"})
    void 유저가_간곳이_유효한지_확인(String bridgePosition, Boolean isAlive) {
        List<String> input = new ArrayList<>(Arrays.stream(bridgePosition.split(",")).collect(Collectors.toList()));
        Bridge bridge = new Bridge(input);

        Assertions.assertThat(bridge.isAlive("U",0)).isEqualTo(isAlive);
    }
}