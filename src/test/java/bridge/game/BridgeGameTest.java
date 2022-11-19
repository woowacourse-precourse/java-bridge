package bridge.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import bridge.BridgeMaker;
import bridge.dto.BridgeGameDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.MockedConstruction;
import java.util.List;
import java.util.stream.Stream;

public class BridgeGameTest {

    @ParameterizedTest(name = "move test Case {index}")
    @ArgumentsSource(MovingTestData.class)
    void moveTest(List<String> bridge, String moveRoute, List<String> exceptRoute) {
        try (MockedConstruction<BridgeMaker> mockBridgeMaker = mockedBridgeMaker(bridge)) {
            BridgeGame bridgeGame = new BridgeGame(bridge.size());

            BridgeGameDto result = bridgeGame.move(moveRoute);

            assertThat(result.getBridge()).isEqualTo(bridge);
            assertThat(result.getRoute()).isEqualTo(exceptRoute);
        }
    }

    static class MovingTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(List.of("U","U","D","D"), "U", List.of("U")),
                    Arguments.of(List.of("U","U","D","D","D"), "D", List.of("D"))
            );
        }
    }

    @Test
    void clearTest() {
        List<String> bridge = List.of("U","U","D","D");
        try (MockedConstruction<BridgeMaker> mockBridgeMaker = mockedBridgeMaker(bridge)) {
            BridgeGame bridgeGame = new BridgeGame(bridge.size());
            bridgeGame.move("U");
            bridgeGame.retry();

            BridgeGameDto result = bridgeGame.move("D");

            assertThat(result.getRoute()).isEqualTo(List.of("D"));
        }
    }

    MockedConstruction<BridgeMaker> mockedBridgeMaker(List<String> bridge) {
        return mockConstruction(BridgeMaker.class,
                withSettings().defaultAnswer(RETURNS_MOCKS),
                (mock, context) -> {
                    when(mock.makeBridge(anyInt())).thenReturn(bridge);
                });
    }
}
