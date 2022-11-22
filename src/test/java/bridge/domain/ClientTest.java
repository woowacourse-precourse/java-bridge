package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import bridge.util.Client;
import bridge.view.ViewMaker;
import java.io.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class ClientTest {

    private ViewMaker viewMaker;

    @BeforeEach
    void init() {
        viewMaker = mock(ViewMaker.class);
    }

    @DisplayName("정상 시나리오 | 다리 건축을 뷰 메이커에게 요청한다.")
    @Test
    void requestBridgeConstructionByViewMaker() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {

            Client.requestBridgeConstruction(viewMaker);

            verify(viewMaker, times(1)).receiveClientRequest();
        }
    }

    @DisplayName("정상 시나리오 | 게임 유저를 뷰 메이커에게 소개한다.")
    @Test
    void introduceGameUserToViewMaker() {
        assertThat(Client.introduceGameUser(viewMaker)).isInstanceOf(User.class);
    }

}
