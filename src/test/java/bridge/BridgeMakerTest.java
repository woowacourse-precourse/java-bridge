package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    BridgeMaker bridgeMaker;
    BridgeNumberGenerator bridgeNumberGenerator;

    @BeforeEach
    void setUp(){
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리가 사용자에게 입력받은 길이대로 생성되는지 확인")
    @Test
    void checkingBridgeSizeisUserInputSize(){
        //given
        int userInputsize = 3;
        int bridgeSize = 6;
        //when
        List<String> actual = bridgeMaker.makeBridge(userInputsize);
        //then
        assertThat(actual.size()).isEqualTo(bridgeSize);
    }

    @DisplayName("위 아래 다리가 사용자가 입력한 사이즈 대로 생성되는지 확인")
    @Test
    void checkUpperAndLowerBridgeSize(){
        //given
        int usesrInputSize = 4;
        String expected = "[U, D, U, D, U, D, U, D]";
        //when
        List<String> actual = bridgeMaker.makeBridge(usesrInputSize);
        //then
        assertThat(actual.toString()).isEqualTo(expected);
    }

    @DisplayName("다리 사이즈 만큼 함정이 생성되는 지 확인")
    @Test
    void checkBridgeTrapSize() {
        //given
        int bridgeSize = 4;
        //when
        List<Integer> actual = bridgeMaker.rawTrap(bridgeSize);
        //then
        assertThat(actual.size()).isEqualTo(bridgeSize);
        
    }
}



