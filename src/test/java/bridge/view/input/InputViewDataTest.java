package bridge.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

public class InputViewDataTest {

    @ParameterizedTest(name = "Case : {0}")
    @ArgumentsSource(BridgeLengthTestData.class)
    void BRIDGE_LENGTH_isCorrectTest(String input, boolean expected) {
         boolean result = InputViewData.BRIDGE_LENGTH.isCorrect(input);

         assertThat(result).isEqualTo(expected);
    }

    private static class BridgeLengthTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("3", true),
                    Arguments.of("20", true),
                    Arguments.of("13", true),
                    Arguments.of("13T", false),
                    Arguments.of("1", false),
                    Arguments.of("50", false)
            );
        }
    }

    @ParameterizedTest(name = "Case : {0}")
    @ArgumentsSource(MovingRouteTestData.class)
    void MOVING_ROUTE_isCorrectTest(String input, boolean expected) {
        boolean result = InputViewData.MOVING_ROUTE.isCorrect(input);

        assertThat(result).isEqualTo(expected);
    }

    private static class MovingRouteTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("U", true),
                    Arguments.of("D", true),
                    Arguments.of("3", false),
                    Arguments.of("P", false)
            );
        }
    }

    @ParameterizedTest(name = "Case : {0}")
    @ArgumentsSource(RetryTestData.class)
    void RETRY_isCorrectTest(String input, boolean expected) {
        boolean result = InputViewData.RETRY.isCorrect(input);

        assertThat(result).isEqualTo(expected);
    }

    private static class RetryTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("R", true),
                    Arguments.of("Q", true),
                    Arguments.of("3", false),
                    Arguments.of("P", false)
            );
        }
    }
}
