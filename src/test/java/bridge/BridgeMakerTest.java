package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.List;
import java.util.stream.Stream;

public class BridgeMakerTest {

    @ParameterizedTest(name = "Case {index}")
    @ArgumentsSource(MakeBridgeTestData.class)
    void makeBridgeTest(List<Integer> mockData, List<String> expected) {
        BridgeNumberGenerator mockBridgeNumberGenerator = mockedBridgeNumberGenerator(mockData);

        List<String> result = new BridgeMaker(mockBridgeNumberGenerator).makeBridge(mockData.size());

        assertThat(result).isEqualTo(expected);
    }

    BridgeNumberGenerator mockedBridgeNumberGenerator(List<Integer> mockData) {
        BridgeNumberGenerator mockBridgeNumberGenerator = mock(BridgeNumberGenerator.class);
        when(mockBridgeNumberGenerator.generate()).thenReturn(mockData.get(0), mockData.get(1), mockData.get(2));
        return mockBridgeNumberGenerator;
    }

    static class MakeBridgeTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(List.of(0, 0, 0), List.of("D", "D", "D")),
                    Arguments.of(List.of(1, 0, 1), List.of("U", "D", "U")),
                    Arguments.of(List.of(1, 1, 1), List.of("U", "U", "U"))
            );
        }
    }
}
