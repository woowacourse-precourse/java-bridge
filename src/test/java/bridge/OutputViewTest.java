package bridge;

import bridge.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @DisplayName("map 출력테스트")
    @Test
    void map_test(){
        String answer="";
        OutputView outputView=new OutputView();
        answer=outputView.printUMap(answer,"U",1);
         answer=outputView.printUMap(answer,"U",2);
        System.out.println(answer);
    }

}