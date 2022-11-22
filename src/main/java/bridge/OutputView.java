package bridge;
import java.util.List;
public class OutputView {
    public void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }
    public void printMap(List<String> makingBridge) {
        System.out.println(makingBridge.get(0));
        System.out.println(makingBridge.get(1)+"\n");
    }
    public void printResult(List<String> makingBridge, int gameCnt) {
        System.out.println("최종 게임 결과");
        printMap(makingBridge);
        if(makingBridge.get(0).contains("X") || makingBridge.get(1).contains("X")) System.out.println("게임 성공 여부: 실패");
        if(!makingBridge.get(0).contains("X") && !makingBridge.get(1).contains("X")) System.out.println("게임 성공 여부: 성공");
        System.out.println("총 시도한 횟수: "+gameCnt);
    }
}