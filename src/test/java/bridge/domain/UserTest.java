package bridge.domain;

import static bridge.constant.InputKeyConstant.UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bridge.view.ViewMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    private ViewMaker viewMaker;
    private User user;

    @BeforeEach
    void init() {
        viewMaker = mock(ViewMaker.class);
        user = new User(viewMaker);
    }

    @DisplayName("정상 시나리오 | 방향 입력을 건설된 다리 위치와 함께 요청한다.")
    @Test
    void requestDirectionByBridgeLocation() {
        CompareResult compareResult = new CompareResult(UP.getFirstLetter(), true, true);
        when(viewMaker.receiveUserDirection(anyInt())).thenReturn(compareResult);

        assertThat(user.requestDirection(0)).isInstanceOf(CompareResult.class);
    }

    @DisplayName("정상 시나리오 | 게임 재시도 명령어를 요청한다.")
    @Test
    void requestGameCommand() {
        assertThat(user.requestGameCommand()).isInstanceOf(Boolean.class);
    }

}
