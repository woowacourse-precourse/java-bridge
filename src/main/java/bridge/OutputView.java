package bridge;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    static int now_size = 0;

    static StringBuilder upBridge = new StringBuilder();
    static StringBuilder downBridge = new StringBuilder();

    public void printResult(){
        System.out.println(upBridge +"\n"+ downBridge + "\n");
    }

    public void initNowSize(){
        now_size = 0;
    }

    public void printSuccess(){
        System.out.println("최종 게임 결과" +"\n"+
                upBridge + "\n" + downBridge +"\n"+
                "게임 성공 여부: 성공" + "\n" +
                "총 시도한 횟수: " + BridgeGame.play_count);
    }

}
