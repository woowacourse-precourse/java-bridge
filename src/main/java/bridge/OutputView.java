package bridge;

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
    public void printMap(List<String> userBridge, List<String> answerBridge) {
        String topLine=printLine(userBridge, answerBridge, "U");
        String downLine=printLine(userBridge, answerBridge, "D");
        System.out.println(topLine);
        System.out.println(downLine);
    }

    public String printLine(List<String> userBridge, List<String> answerBridge,String location){
        String line="[ ";
        line+=printOneLine(userBridge,answerBridge,location);
        line+="]";
        return line;
    }

    public String printOneLine(List<String> userBridge, List<String> answerBridge, String location){
        String oneLine="";
        for(int index=0;index<userBridge.size();index++){
            if(!checkSameLocation(userBridge,index, location)){
                oneLine+="  ";
            }
            if(checkSameLocation(userBridge,index, location)){
                oneLine+=getOX(userBridge,answerBridge,index);
            }
            oneLine+=getPartition(index,userBridge);
        }return oneLine;
    }

    public String getPartition(int index, List<String> userBridge){
        if(index< userBridge.size()-1) {
            return  "| ";
        }
        return "";
    }

    public String getOX(List<String> userBridge, List<String> answerBridge, int index){
        if(checkSameMove(userBridge, answerBridge, index)){
            return "O ";
        }
        return "X ";
    }

    public boolean checkSameLocation(List<String> userBridge, int index, String location){
        if(!userBridge.get(index).equals(location)){
            return false;
        }
        return true;
    }

    public boolean checkSameMove(List<String> userBridge, List<String> answerBridge, int index){
        if(userBridge.get(index).equals(answerBridge.get(index))){
            return true;
        }
        return false;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> userBridge, List<String> answerBridge, int gameCount) {
        System.out.println("최종 게임 결과");
        printMap(userBridge,answerBridge);
        System.out.println();
        boolean check=checkSuccess(userBridge,answerBridge);
        printSuccess(check);
        System.out.println("총 시도한 횟수: "+gameCount);
    }

    public boolean checkSuccess(List<String> userBridge, List<String> answerBridge){
        if(userBridge.size()!=answerBridge.size()){
            return false;
        }
        for(int index=0;index<userBridge.size();index++){
            if(!userBridge.get(index).equals(answerBridge.get(index))){
                return false;
            }
        }
        return true;
    }

    public void printSuccess(boolean check){
        System.out.print("게임 성공 여부: ");
        if(check){
            System.out.println("성공");
            return ;
        }
        System.out.println("실패");
    }
}
