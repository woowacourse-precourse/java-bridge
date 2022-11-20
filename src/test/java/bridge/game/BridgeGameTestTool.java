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

    void moveByMovingRoute(List<String> movingRoutes, BridgeGame bridgeGame) {
        for (String movingRoute : movingRoutes) {
            bridgeGame.move(movingRoute);
        }
    }
}
