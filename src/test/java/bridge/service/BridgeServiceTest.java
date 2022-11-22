package bridge.service;

import bridge.global.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class BridgeServiceTest {

    private BridgeService bridgeService;

    @BeforeEach
    void beforeEach(){
        bridgeService = new BridgeService();
    }

    @Test
    public void makeBridge() throws Exception{
        //given
        String length = "10";
        //when
        List<String> bridge = bridgeService.makeBridge(length);
        //then
        assertThat(bridge.size()).isEqualTo(Integer.parseInt(length));
    }

    @Test
    @DisplayName("다리의 길이를 3미만으로 입력할 경우")
    public void makeBridgeErrorV1() throws Exception{
        //given
        String length = "2";
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bridgeService.makeBridge(length);
        });
        //then
        assertThat(exception.getMessage()).
                isEqualTo(ErrorMessage.INPUT_BRIDGE_LENGTH_ERROR.getMessage());
    }

    @Test
    @DisplayName("다리의 길이를 20초과로 입력할 경우")
    public void makeBridgeErrorV2() throws Exception{
        //given
        String length = "21";
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bridgeService.makeBridge(length);
        });
        //then
        assertThat(exception.getMessage()).
                isEqualTo(ErrorMessage.INPUT_BRIDGE_LENGTH_ERROR.getMessage());
    }

    @Test
    @DisplayName("다리의 길이를 문자로 입력할 경우")
    public void makeBridgeErrorV3() throws Exception{
        //given
        String length = "2a3";
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bridgeService.makeBridge(length);
        });
        //then
        assertThat(exception.getMessage()).
                isEqualTo(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
    }

    @Test
    @DisplayName("이동 위치를 올바르게 입력했을 경우")
    public void moveGood() throws Exception{
        //given
        String move = "U";
        //when, then
        bridgeService.validateUserMove(move);
    }
}