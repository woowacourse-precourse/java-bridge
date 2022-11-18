package bridge.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import bridge.BridgeMaker;
import bridge.view.ViewMaker;
import java.io.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class ClientTest {

    private ViewMaker viewMaker;
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        viewMaker = mock(ViewMaker.class);
        bridgeMaker = mock(BridgeMaker.class);
    }

    @DisplayName("정상 시나리오 | 다리 건축을 뷰 메이커에게 요청한다.")
    @Test
    void requestBridgeConstructionByViewMaker() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {

            Client.requestBridgeConstruction(viewMaker);

            verify(viewMaker, times(1)).receiveClientRequest();
        }
    }

}
