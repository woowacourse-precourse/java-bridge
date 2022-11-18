package bridge.view;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import bridge.BridgeMaker;
import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class ViewMakerTest {

    private BridgeMaker bridgeMaker;
    private InputView inputView;
    private OutputView outputView;
    private ViewMaker viewMaker;

    @BeforeEach
    void init() {
        bridgeMaker = mock(BridgeMaker.class);
        viewMaker = new ViewMaker(bridgeMaker);
        inputView = mock(InputView.class);
        outputView = mock(OutputView.class);
    }

    @DisplayName("클라이언트의 다리 만들기 요청을 받는다. | 정상 시나리오 테스트")
    @Test
    void receiveClientRequestByBridgeConstruction() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            String testBridgeSize = "3";

            when(Console.readLine()).thenReturn(testBridgeSize);
            when(bridgeMaker.makeBridge(anyInt())).thenReturn(Collections.emptyList());

            viewMaker.receiveClientRequest();

            verify(bridgeMaker, times(1)).makeBridge(anyInt());
        }
    }

}
