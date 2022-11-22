package bridge.function;

import bridge.BridgeGame;
import bridge.util.InputView;
import bridge.util.OutputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class OutputViewTest {

    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeGame bg;

    @BeforeAll
    static void initailize(){
        inputView=new InputView();
        outputView=new OutputView();
        bg=new BridgeGame();
    }

    @Test
    @DisplayName("다리가 정상적으로 생산이 되는지")
    void correctDrawTheMap(){
        //given
        StringBuilder sb=new StringBuilder();
        List<String> move_result_list = move_result_list();
        //when
        for (int i=0;i<move_result_list.size();i++){
            sb=bg.move(move_result_list.get(i),i);
        }
        //then
        assertThat(sb.toString()).isEqualTo(drawTestMap().toString());
    }

    @Test
    @DisplayName("다리건너기 결과가 정상적으로 동작하는지-성공")
    void correctCrossingTheBridgeResultSuccess(){
        //given
        String result="SUCCESS";
        //when
        String retry_result = bg.retry(result, inputView, outputView);
        //then

        assertThat(result).isEqualTo(retry_result);
    }


    private List<String> move_result_list(){
        List<String> list=new ArrayList<>();
        list.add("OU");
        list.add("OD");
        list.add("XU");
        return list;
    }

    private StringBuilder drawTestMap(){
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2= new StringBuilder();
        StringBuilder result=new StringBuilder();
        sb1.append("[ O |   | X ]");
        sb2.append("[   | O |   ]");
        return result.append(sb1).append("\n").append(sb2);
    }
}
