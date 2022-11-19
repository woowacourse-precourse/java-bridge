package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private Validation validation =  new Validation();
    @Test
    @DisplayName("다리 길이에 대한 입력 Integer 변환 - 성공")
    public void Convert_Success() throws Exception{
        String bridgeSize = "4";
        validation.bridgeLen(bridgeSize);
        Integer len = Integer.parseInt(bridgeSize);
        Assertions.assertThat(len).isEqualTo(4);
    }

    @Test
    @DisplayName("다리 길이에 대한 입력 Integer 변환 - 숫자가 아닌 겨우 변환 실패")
    public void Convert_fail_NotNumber() throws Exception{
        String bridgeSize = "hi";
        Assertions.assertThatThrownBy(()->
            validation.bridgeLen(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    @DisplayName("다리 길이에 대한 입력 Integer 변환 - 3미만 20초과인 경우 변환 실패")
    public void Convert_fail_Range() throws Exception{
        String bridgeSizeThan = "21";
        Assertions.assertThatThrownBy(()->
            validation.bridgeLen(bridgeSizeThan))
                .isInstanceOf(IllegalArgumentException.class);

        String bridgeSizeLess = "2";
        Assertions.assertThatThrownBy(()->
                        validation.bridgeLen(bridgeSizeLess))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("이동할 칸에 대한 입력 - 성공")
    public void move_success() throws Exception{
        String command = "U";
        validation.moveCommand(command);
        Assertions.assertThat(command).isEqualTo(BridgeConst.UP);
        command = "D";
        validation.moveCommand(command);
        Assertions.assertThat(command).isEqualTo(BridgeConst.DOWN);

    }

    @Test
    @DisplayName("이동할 칸에 대한 입력 - 실패")
    public void move_fail() throws Exception{
        List<String> command = new ArrayList<>(
                List.of("A","B","C","d","E","F","G","H","I","J","K",
                        "L","M","N","O","P","Q","R","S","T","u","V","W","X","Y","Z"));
        command.stream()
                .forEach(element->{
                    Assertions.assertThatThrownBy(()->validation.moveCommand(element))
                            .isInstanceOf(IllegalArgumentException.class);
                });
    }

    @Test
    @DisplayName("게임 다시 시도 여부 입력 - 성공")
    public void retry_success() throws Exception{
        String command = "R";
        validation.retryCommand(command);
        Assertions.assertThat(command).isEqualTo(BridgeConst.RETRY);
        command = "Q";
        validation.retryCommand(command);
        Assertions.assertThat(command).isEqualTo(BridgeConst.QUIT);

    }

    @Test
    @DisplayName("게임 다시 시도 여부 입력 - 실패")
    public void retry_fail() throws Exception{
        List<String> command = new ArrayList<>(
                List.of("A","B","C","d","E","F","G","H","I","J","K",
                        "L","M","N","O","P","q","r","S","T","u","V","W","X","Y","Z"));
        command.stream()
                .forEach(element->{
                    Assertions.assertThatThrownBy(()->validation.moveCommand(element))
                            .isInstanceOf(IllegalArgumentException.class);
                });
    }



}