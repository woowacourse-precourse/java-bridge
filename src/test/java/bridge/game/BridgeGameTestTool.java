package bridge.game;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import bridge.BridgeMaker;
import bridge.dto.BridgeGameDto;
import org.mockito.MockedConstruction;
import java.util.List;

public abstract class BridgeGameTestTool {

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
