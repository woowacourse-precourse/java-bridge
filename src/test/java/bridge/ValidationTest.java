package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {


    @Test
    @DisplayName("다리 기능 입력에 대한 validation - 숫자 입력이 아닌 경우")
    public void bridgeLenTest() throws Exception{
        Assertions.assertThatThrownBy(()->
            notNumberFormat("숫자가 아님")
        ).isInstanceOf(IllegalArgumentException.class);
    }
    private void notNumberFormat(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력은 3이상 20이하의 숫자를 입력할 수 있습니다.");
        }
    }

    private void bridgeLen(String input){
        notNumberFormat(input);
        Integer len = Integer.parseInt(input);
        if(len < 3 || len > 20) throw new IllegalArgumentException("[ERROR] 다리 길이 입력은 3이상 20이하의 숫자를 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("다리 기능 입력에 대한 validation - 3미만")
    public void 다리길이가_3미만() throws Exception{
        Assertions.assertThatThrownBy(() ->bridgeLen("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리 기능 입력에 대한 validation - 20초과 ")
    public void 다리길이가_20초과() throws Exception{
        Assertions.assertThatThrownBy(() ->bridgeLen("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("다리 기능 입력에 대한 validation - 성공 ")
    public void 다리_길이_성공() throws Exception{
        Assertions.assertThatCode(() ->bridgeLen("15"))
                .doesNotThrowAnyException();

    }


    @Test
    @DisplayName("이동할 칸에 대한 입력 validation - U 또는 D가 아닌 경우")
    public void 실패_케이스() throws Exception{
        String input = "Z";
        Assertions.assertThatThrownBy(()->moveCommand(input))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    @DisplayName("이동할 칸에 대한 입력 validation - U 또는 D 인경우")
    public void 성공_케이스() throws Exception{

        Assertions.assertThatCode(()->moveCommand("U"))
                .doesNotThrowAnyException();

        Assertions.assertThatCode(()->moveCommand("D"))
                .doesNotThrowAnyException();
    }
    private void moveCommand(String cmd){
        if(!(cmd.equals("U") || cmd.equals("D"))) throw new IllegalArgumentException("[ERROR] 이동할 칸은 (위: U, 아래: D)만 입력해주세요.");
    }

    @Test
    @DisplayName(" 게임 다시 시도 여부 입력 Validation - R 또는 Q인 경우")
    public void retry_성공_케이스() throws Exception{
        Assertions.assertThatCode(()->retryCommand("R"))
                .doesNotThrowAnyException();

        Assertions.assertThatCode(()->retryCommand("Q"))
                .doesNotThrowAnyException();

    }
    @Test
    @DisplayName(" 게임 다시 시도 여부 입력 Validation - R 또는 Q가 아닌 경우")
    public void retry_실패_케이스() throws Exception{
        Assertions.assertThatThrownBy(()->retryCommand("U"))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->retryCommand("D"))
                .isInstanceOf(IllegalArgumentException.class);


    }
    private void retryCommand(String cmd){
        if(!(cmd.equals("R") || cmd.equals("Q"))) throw new IllegalArgumentException("[ERROR] 다시 시도 여부는 (재시도: R, 종료: Q)만 입력해주세요.");
    }




}