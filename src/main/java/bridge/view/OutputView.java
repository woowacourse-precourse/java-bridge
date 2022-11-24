package bridge.view;

import java.util.List;

public class OutputView {

    public void printMap(List<String> results) {
        System.out.print("[ ");
        for(int i=0; i<results.size(); i++){
            System.out.print(results.get(i));
            if(i==results.size()-1){
                break;
            }
            System.out.print(" | ");
        }
        System.out.println(" ]");
    }

    public void printResult(String result, int tryNum) {
        System.out.println("\n게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + tryNum);
    }

    public void printEnding() {
        System.out.println("최종 게임 결과");
    }

    public void printGameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    public void enter(){
        System.out.println();
    }
}
