package bridge;

import java.util.List;

import static bridge.Application.myBridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean isExit = false;

    public static String[][] move(List<String> bridge, String movingPoint) {
        myBridge.add(movingPoint);
        String[][] map = new String[2][myBridge.size()];
        for(int i = 0; i < myBridge.size(); i++){
            if(bridge.get(i).equals(myBridge.get(i))){
                if(bridge.get(i).equals("U")) {
                    map[0][i] = "O";
                    map[1][i] = " ";
                    isExit = false;
                }
                if(bridge.get(i).equals("D")) {
                    map[0][i] = " ";
                    map[1][i] = "O";
                    isExit = false;
                }
            }
            if(!(bridge.get(i).equals(myBridge.get(i)))){
                if(bridge.get(i).equals("U")) {
                    map[0][i] = " ";
                    map[1][i] = "X";
                    isExit = true;
                }
                if(bridge.get(i).equals("D")) {
                    map[0][i] = "X";
                    map[1][i] = " ";
                    isExit = true;
                }
            }
        }
        return map;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
