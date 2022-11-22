package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    List<List<String>> map=new ArrayList<>();
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String >> map) {
        for (int i = 0; i < map.size(); i++)
            for (int j = 0; j < map.get(0).size(); j++)
                printList(map.get(i));
    }



    public void printList(List<String> strings){
        String outString="[ ";
        for (int i = 0; i < strings.size(); i++) {
            outString+=strings.get(i);
            if(i== strings.size()-1)
                break;
            outString+=" | ";
        }
        outString+=" ]";
        System.out.println(outString);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getMap());
        System.out.println("게임 성공 여부: "+bridgeGame.isSuccess());
        System.out.println("총 시도한 횟수: "+bridgeGame.getPlayer().getAttempt());
    }
}
