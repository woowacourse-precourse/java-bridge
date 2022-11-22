package bridge;

import org.mockito.internal.matchers.Null;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    String[][] check_msg;
    int result = 0;
    int trial = 0;
    public int printMap(List<String> answerList, List<String> inputList) {
        setSettings(answerList,inputList);
        for (int i = 0; i < inputList.size(); i++) {
            String chk = Check(answerList.get(i), inputList.get(i));
            if (chk.equals("0")){
                nullCheck(answerList.get(i),i);
                printMsg(inputList.size());
                return 0;
            } ansCheck(chk,i);
        } printMsg(inputList.size());
        this.result = 1;
        return 1;
    }
    public void setSettings(List<String> answerList, List<String> inputList){
        this.check_msg = new String[2][answerList.size()];
        this.trial = inputList.size();
    }
    public String Check(String answerStr,String inputStr){
        if (answerStr.equals(inputStr)){
            if(answerStr.equals("U")){
                return "U";
            }
            return "D";
        }
        return "0";
    }
    public void nullCheck(String answerStr, int i){
        if (answerStr.equals("U")){
            this.check_msg[0][i] = " ";
            this.check_msg[1][i] = "X";
            return;
        }
        this.check_msg[0][i] = "X";
        this.check_msg[1][i] = " ";
    }

    public void ansCheck(String chk, int i){
        if (chk.equals("U")){
            this.check_msg[0][i] = "O";
            this.check_msg[1][i] = " ";
            return;
        }
        this.check_msg[0][i] = " ";
        this.check_msg[1][i] = "O";
    }
    public void printMsg(int len){
        for (int i = 0; i<2; i++){
            System.out.print("[ ");
            System.out.print(this.check_msg[i][0]);
            for(int j = 1; j<len; j++){
                System.out.print(" | "+this.check_msg[i][j]);
            }
            System.out.println(" ]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryCnt) {
        System.out.println();
        System.out.println("최종 게임 결과");
        printMsg(trial);
        System.out.println();
        String resultMsg = "성공";
        if (result==0){
            resultMsg = "실패";
        }
        System.out.println("게임 성공 여부: "+resultMsg);
        System.out.println("총 시도한 횟수: "+tryCnt);
    }
}
