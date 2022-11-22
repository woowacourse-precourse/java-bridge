package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public String checkBridge(List<String> nextStep, List<String> Bridge , int i){
        String str="";
        if(nextStep.get(i).equals(Bridge.get(i))){
            str=" O ";
        }
        if(!nextStep.get(i).equals(Bridge.get(i))){
            str=" X ";
        }
        return str;
    }
}
