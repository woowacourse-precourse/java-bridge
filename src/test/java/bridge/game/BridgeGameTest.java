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
    void moveTest(List<String> bridge, List<String> movingRoute) {
        try (MockedConstruction<BridgeMaker> mockBridgeMaker = mockedBridgeMaker(bridge)) {
            BridgeGame bridgeGame = new BridgeGame(bridge.size());

            BridgeGameDto result = moveByMovingRoute(movingRoute, bridgeGame);

            assertThat(result.getBridge()).isEqualTo(bridge);
            assertThat(result.getRoute()).isEqualTo(movingRoute);
        }
    }

    static class MovingTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(List.of("U","U","D","D"), List.of("U")),
                    Arguments.of(List.of("U","U","D","D","D"),  List.of("D")),
                    Arguments.of(List.of("U","U","D","D"), List.of("U","U")),
                    Arguments.of(List.of("U","U","D","D","D"),  List.of("U","U","D","U"))
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

    @ParameterizedTest(name = "isContinue test Case {index}")
    @ArgumentsSource(IsContinueTestData.class)
    void isContinueTest(List<String> bridge, List<String> movingRoute, boolean excepted) {
        try (MockedConstruction<BridgeMaker> mockBridgeMaker = mockedBridgeMaker(bridge)) {
            BridgeGame bridgeGame = new BridgeGame(bridge.size());
            moveByMovingRoute(movingRoute, bridgeGame);

            boolean result = bridgeGame.isContinue();

            assertThat(result).isEqualTo(excepted);
        }
    }

    static class IsContinueTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(List.of("U","U","D","D"), List.of("U"), true),
                    Arguments.of(List.of("U","U","D","D","D"),  List.of("D"), false),
                    Arguments.of(List.of("U","U","D","D"), List.of("U","U"), true),
                    Arguments.of(List.of("U","U","D","D","D"),  List.of("U","U","D","U"), false)
            );
        }
    }

    MockedConstruction<BridgeMaker> mockedBridgeMaker(List<String> bridge) {
        return mockConstruction(BridgeMaker.class,
                withSettings().defaultAnswer(RETURNS_MOCKS),
                (mock, context) -> {
                    when(mock.makeBridge(anyInt())).thenReturn(bridge);
                });
    }

    BridgeGameDto moveByMovingRoute(List<String> movingRoutes, BridgeGame bridgeGame) {
        BridgeGameDto bridgeGameDto = null;
        for (String movingRoute : movingRoutes) {
            bridgeGameDto = bridgeGame.move(movingRoute);
        }
        return bridgeGameDto;
    }
}
