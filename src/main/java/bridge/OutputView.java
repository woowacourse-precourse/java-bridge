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

    static List<String> bridge_answer = new ArrayList<>();
    static StringBuilder upBridge = new StringBuilder();
    static StringBuilder downBridge = new StringBuilder();


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(){
        System.out.println(upBridge);
        System.out.println(downBridge);
        System.out.println("\n");
    }

    public void initNowSize(){
        now_size = 0;
    }

}
