package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static final int UP = 0;
    static final int DOWN = 0;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    static public void printMap(List<String> trace, boolean result) {
        List<String> updown = new ArrayList<>(2);
        updown = addStr(updown, "[");
        int size = trace.size();
        for (int i = 0; i < size - 1; i++) {
            updown = addTrace(trace.get(i), updown, true);
            updown = addStr(updown, "|");
        }
        updown = addTrace(trace.get(size - 1), updown, result);
        updown = addStr(updown, "]");
        System.out.println(updown);
    }

    static public List<String> addTrace(String trace, List<String> updown, boolean success){
        List<String> temp = new ArrayList<>();
        String OX = " O ";
        if (!success)
            OX = " X ";
        if(trace.equals("U")) {
            temp = addUp(updown, OX);
        }
        if(trace.equals("D"))
            temp = addStr(updown, OX);
        return temp;
    }

    static public List<String> addStr(List<String> updown, String str){
        updown.get(UP).concat(str);
        updown.get(DOWN).concat(str);
        return updown;
    }

    static public List<String> addUp(List<String> updown, String OX){
        List<String> temp = new ArrayList<>();
        temp.add(updown.get(UP).concat(OX));
        temp.add(updown.get(DOWN));
        return temp;
    }
    static public List<String> addDown(List<String> updown, String OX){
        List<String> temp = new ArrayList<>();
        temp.add(updown.get(UP));
        temp.add(updown.get(DOWN).concat(OX));
        return temp;
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
