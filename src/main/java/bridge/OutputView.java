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
    public void printMap(List<String> curBridges, int curIdx) {
        printOneBridge(curBridges, curIdx, 0);
        printOneBridge(curBridges, curIdx, 1);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> curBridges, boolean flag, int cnt) {
        System.out.println("최종 게임 결과");
        printOneBridge(curBridges, curBridges.get(0).length()-1, 0);
        printOneBridge(curBridges, curBridges.get(1).length()-1, 1);
        System.out.println();

        if(flag){ System.out.println("게임 성공 여부: 실패"); }
        if(!flag){ System.out.println("게임 성공 여부: 성공"); }
        System.out.println("총 시도한 횟수: "+cnt);
    }

    /*
    하나의 다리를 출력하는 메소드
     */
    public void printOneBridge(List<String> curBridges, int size, int bridgeIdx){
        System.out.print("[");
        for(int i=0;i<size+1;i++){
            if(i==0){ System.out.print(" "+curBridges.get(bridgeIdx).charAt(i)+" "); }
            if(i!=0){ System.out.print("| "+curBridges.get(bridgeIdx).charAt(i)+" "); }
        }
        System.out.println("]");
    }
}
