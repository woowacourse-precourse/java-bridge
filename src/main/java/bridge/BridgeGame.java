package bridge;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static int index = 0;
    public static int gameCount = 1;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge, String readMoving) {
        if (bridge.get(index).equals(readMoving)){
            return (true);
        }
        return (false);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> bridge, int bridgeSize) {
        index = 0;
        gameCount += 1;
        Game reGame = new Game();
        reGame.Start(bridge, bridgeSize);
    }

    public List<String> makeMap(String input, boolean move){
        List<String> mapString = new ArrayList<>();
        if (input.equals("U") && move){
            MapString.upstairs += "O";
            MapString.downstairs += " ";
        }
        else if (input.equals("U")){
            MapString.upstairs += "X";
            MapString.downstairs += " ";
        }
        else if (input.equals("D") && move){
            MapString.upstairs += " ";
            MapString.downstairs += "O";
        }
        else if (input.equals("D")){
            MapString.upstairs += " ";
            MapString.downstairs += "X";
        }
        mapString.add(MapString.upstairs);
        mapString.add(MapString.downstairs);
        return (mapString);
    }
}
