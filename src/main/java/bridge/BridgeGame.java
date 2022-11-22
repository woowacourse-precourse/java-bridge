package bridge;

import camp.nextstep.edu.missionutils.Console;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private String Correct = " O ";
    private String False = " X ";
    private String Space = "   ";
    private int count= 1;
     StringBuffer T = new StringBuffer("[]");
     StringBuffer B = new StringBuffer("[]");
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<StringBuffer> move(String answer,int i,String choice) {
        int result = 0;
        List<StringBuffer> Print = new ArrayList<>();
        if(choice.equals("U")){
            Print = Top(answer,choice);
        } else if (choice.equals("D")) {
            Print = Bottom(answer,choice);
        }
        count = count + 4;
        return Print;
    }
    private List<StringBuffer> Top(String answer,String choice){
        List<StringBuffer> topPrint = new ArrayList<>();
        if(answer.equals(choice)){
            T.insert(count, Correct);
            B.insert(count, Space);
        }else if(answer.equals(choice) == false){
            T.insert(count, False);
            B.insert(count, Space);
        }
        topPrint.add(0,T);
        topPrint.add(1,B);
        return topPrint;
    }

    private List<StringBuffer> Bottom(String answer,String choice){
        List<StringBuffer> bottomPrint = new ArrayList<>();
        if(answer.equals(choice)){
            T.insert(count, Space);
            B.insert(count, Correct);
        }else if(answer.equals(choice) == false){
            T.insert(count, Space);
            B.insert(count, False);
        }
        bottomPrint.add(0,T);
        bottomPrint.add(1,B);
        return bottomPrint;
    }

    public void slice(int i, int count, StringBuffer T,StringBuffer B){
        if(i!=count-1){
            T.insert(count - 1, "|");
            B.insert(count - 1, "|");
        }
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry() {
        InputView input = new InputView();
        String choice = input.readGameCommand();
        return choice;
    }




}
