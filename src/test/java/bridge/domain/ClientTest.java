package bridge.domain;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import bridge.view.ViewMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class ClientTest {

    @DisplayName("다리 건축을 뷰 메이커에게 요청한다.")
    @Test
    void requestBridgeConstructionByViewMaker() {
        try (MockedStatic<Client> client = mockStatic(Client.class)) {
            ViewMaker viewMaker = mock(ViewMaker.class);

            Client.requestBridgeConstruction(any(ViewMaker.class));

            verify(viewMaker, times(1)).receiveClientRequest();
        }
    }

}
