package bridge.BridgeGame;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    List<String> bridge;
    StringBuilder top;
    StringBuilder bottom;

    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
        this.top = new StringBuilder();
        this.bottom = new StringBuilder();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int currentLocation, String move) {
        boolean flag = true;

        if(move.equals("U")) flag = compareTop(currentLocation, bridge);
        if(move.equals("D")) flag = compareBottom(currentLocation, bridge);

        return flag;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String reply) {
        boolean flag = false;
        if(reply.equals("R")) flag = true;
        return flag;
    }

    private boolean compareTop(int location, List<String> bridge) {
        // 다리를 맞춘 경우
        if(bridge.get(location).equals("U")) {
            top.append('O');
            bottom.append(' ');
            return true;
        }

        // 다리를 틀린 경우
        top.append('X');
        bottom.append(' ');
        return false;
    }

    private boolean compareBottom(int location, List<String> bridge) {
        // 다리를 맞춘 경우
        if(bridge.get(location).equals("D")) {
            bottom.append('O');
            top.append(' ');
            return true;
        }

        // 다리를 틀린 경우
        bottom.append('X');
        top.append(' ');
        return false;
    }

    public List<StringBuilder> getBridgeFair(){
        ArrayList<StringBuilder> bridgeFair = new ArrayList<>();
        bridgeFair.add(this.top);
        bridgeFair.add(this.bottom);

        return bridgeFair;
    }

    public int getBridgeSize() {
        return this.bridge.size();
    }

    public void clear(){
        this.top = new StringBuilder();
        this.bottom = new StringBuilder();
    }
}
