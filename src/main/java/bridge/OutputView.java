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
    public String separate(int i,int turn){
        String str="";
        if(i!=turn-1){
            str = "|";
        }
        if(i==turn-1){
            str="]";
        }
        return str;
    }
    public String printMap(List<String> nextStep, List<String> Bridge, int turn) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append("[");sb2.append("[");
        String result = checkBridge(nextStep, Bridge, nextStep.size()-1);
        for(int i=0;i<turn;i++){
            if(nextStep.get(i).equals("U")){
                sb.append(checkBridge(nextStep,Bridge,i)).append(separate(i,turn));
                sb2.append("   ").append(separate(i,turn));
            }
            if(nextStep.get(i).equals("D")){
                sb.append("   ").append(separate(i,turn));
                sb2.append(checkBridge(nextStep,Bridge,i)).append(separate(i,turn));
            }
        }
        System.out.println(sb.append('\n').append(sb2));
        return result;
    }

}
