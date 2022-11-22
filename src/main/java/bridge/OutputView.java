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
    public void printMap(String move,  List<String>upBridge ,List<String> downBridge) {
        /*BridgeNumberGenerator BridgeNumberGenerator = null;
        BridgeMaker BridgeMaker = new BridgeMaker(BridgeNumberGenerator);
        if(move.charAt(0) == 'U'){
            BridgeMaker.bridgeAddMove(move , upBridge);
            BridgeMaker.bridgeAddElseMove(downBridge);
        }else {
            BridgeMaker.bridgeAddMove(move , downBridge);
            BridgeMaker.bridgeAddElseMove(upBridge);}*/
        printCourse(upBridge);
        printCourse(downBridge);
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printCourse(List<String> Bridge) {
        System.out.print("[");
        for (int i = 0; i <Bridge.size() ; i++) {
            if(i == Bridge.size() -1){
                continue;
            }
            System.out.print(Bridge.get(i));
        }
        System.out.print("]");
        System.out.println("");
    }

    public void printResult(List<String> upBridge,List<String> downBridge, int size , int retryNum) {
        System.out.println("최종 게임 결과");
        printCourse(upBridge);
        printCourse(downBridge);
        var msg ="";
        if(size == 0)msg="성공";
        else msg="실패";
        System.out.println("최종 게임 결과" + msg);
        System.out.println("총 시도한 횟수:"+ retryNum);

    }
}
