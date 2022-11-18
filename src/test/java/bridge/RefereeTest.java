package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class RefereeTest {
    private static Referee referee;

    @BeforeAll
    static void init() {
        referee = new Referee(new ArrayList<>(Arrays.asList("U", "U", "U")));
    }

    @Test
    void checkBridgeSizeEquals() {
        referee.isSizeEquals(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"U,0,true","D,0,false"},delimiter = ',')
    void checkStepSuccess(String currentItem,int index,boolean expected) {
        assertThat(referee.isStepSuccess(currentItem, index))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateBridgeExpectedData")
    void checkCompareBridgeWith(List<String> bridge, boolean expected) {
        assertThat(referee.compareBridgeWith(bridge))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> generateBridgeExpectedData() {
        return Stream.of(
                Arguments.of( Arrays.asList("U", "U", "U"), true),
                Arguments.of( Arrays.asList("U", "U", "D"), false)
        );
    }
}