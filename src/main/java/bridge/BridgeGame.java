package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Application.makeMap;
import static bridge.Application.makeMove;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    static List<String> inputMove = new ArrayList<>();
    public static boolean checkCommand(String command){
        if(command.equals("R")){
            return true;
        }
        return false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean move(List<String> bridge) {
        inputMove = new ArrayList<>();
        for(int i = 0; i< bridge.size();i++){
            makeMove();
            makeMap(i,bridge,inputMove);
            if(!validMove(bridge.get(i),inputMove.get(i))) return false;
        }
        return true;
    }
    public static boolean validMove(String bridge, String move){
        return (bridge.equals(move));
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean retry(List<String> bridge) {
        return move(bridge);
    }
}
