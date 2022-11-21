package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> UpMap;
    private List<String> DownMap;
    private List<String> randomMap;
    private int idx;
    private boolean flag;

    public boolean move(String move) {
            buildUserMap(move);
            idx++;
        return flag;
    }

    private void buildUserMap(String move) {
        if(move.equals("U")) {
            validateMove("U", UpMap, DownMap);
        }
        if(move.equals("D")) {
            validateMove("D", DownMap, UpMap);
        }

    }

    private void validateMove(String move, List<String> list1, List<String> list2) {
        if(randomMap.get(idx).equals(move)) {
            list1.add("O");
        }
        if(!randomMap.get(idx).equals(move)) {
            list1.add("X");
            flag = false;
        }
        list2.add(" ");
    }

    public void retry() {
        init();
    }

    public void init() {
        UpMap = new ArrayList<>();
        DownMap = new ArrayList<>();
        idx = 0;
        flag = true;
    }

    public void setRandomMap(List<String> randomMap) {
        this.randomMap = randomMap;
    }

    public List<String> getUpMap() {
        return UpMap;
    }

    public List<String> getDownMap() {
        return DownMap;
    }

}
