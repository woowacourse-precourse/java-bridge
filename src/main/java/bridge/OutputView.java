package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    String up="";
    String down="";
    String checkFlag= "";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void makeBridge(List<String> moveInfo) {
        for(int idx=0;idx<moveInfo.size()-1;idx++){
            if (moveInfo.get(idx).equals("U")) {
                up+="O | ";
                down+="  | ";
            }
            if(moveInfo.get(idx).equals("D")){
                up+="  | ";
                down+="O | ";
            }
        }
    }
    public void successBridge(List<String> moveInfo) {
        if (moveInfo.get(moveInfo.size()-1).equals("U")) {
            up+="O ]";
            down+="  ]";
            System.out.println("U");
        }
        if (moveInfo.get(moveInfo.size()-1).equals("D")) {
            up+="  ]";
            down+="O ]";
            System.out.println("D");
        }
        printResultBridge();
    }
    public String printMap(List<String> moveInfo, List<String> map) {
        up = "[ ";
        down = "[ ";
        makeBridge(moveInfo);
        if(moveInfo.get(moveInfo.size()-1).equals(map.get(moveInfo.size()-1))){
            successBridge(moveInfo);
            checkFlag= "성공";
            return "성공";
        }
        failBridge(moveInfo);
        checkFlag= "실패";
        return  "실패";
    }
    public void failBridge(List<String> moveInfo){
        if (moveInfo.get(moveInfo.size()-1).equals("U")) {
            up+="X ]";
            down+="  ]";
            System.out.println("U");
        }
        if (moveInfo.get(moveInfo.size()-1).equals("D")) {
            up+="  ]";
            down+="X ]";
            System.out.println("D");
        }
        printResultBridge();
    }
    public void printResultBridge(){
        System.out.println(up);
        System.out.println(down+"\n");
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
