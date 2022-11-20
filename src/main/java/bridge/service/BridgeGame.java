package bridge.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public String OX(List<String> bridge,String moving, int index){//"O","X"반환
        if(bridge.get(index).equals(moving)) return "O";
        return "X";
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(List<String> str, String ox, String moving) {
        String toadd = "";
        if(str.get(0).length()!=2) toadd = toadd + "|";
        List<String> OorX = new ArrayList<>();

        if(moving.equals("U")) OorX = Arrays.asList(ox," ");
        if(moving.equals("D")) OorX = Arrays.asList(" ",ox);
        return addString(str,OorX,toadd);
    }

    private List<String> addString(List<String> str, List<String> OorX, String toadd){
        List<String> result = new ArrayList<>();
        result.add(str.get(0).substring(0, str.get(0).length() - 1) + toadd + " " + OorX.get(0) + " ]");
        result.add(str.get(1).substring(0, str.get(1).length() - 1) + toadd + " " + OorX.get(1) + " ]");
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if(command.equals("Q")) return false;
        return true;
    }
}
