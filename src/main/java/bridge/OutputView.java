package bridge;

import java.util.ArrayList;
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
    public void printMap(List<String> userList, List<String> targetBridge) {
        String up = makeUpBridge(userList, targetBridge).toString();
        System.out.println(up.replace(", ", "|"));
        String Down = makeDownBridge(userList, targetBridge).toString();
        System.out.println(Down.replace(", ", "|"));
    }

    public List<String> makeUpBridge(List<String> userList, List<String> tb) {
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            String target = tb.get(i);
            tmp.add(checkUpDown("U", target));
        }
        return tmp;
    }

    public List<String> makeDownBridge(List<String> userList, List<String> tb) {
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            String target = tb.get(i);
            tmp.add(checkUpDown("D", target));
        }
        return tmp;
    }

    public String checkUpDown(String way, String target) {
        if (target.equals(way)) {
            return " O ";
        }
        if (!target.equals(way)) {
            return "   ";
        }
        return " ";
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResultTotalNumber(int totalNumber) {
        System.out.println("총 시도한 횟수: " + totalNumber);
    }

    public void printResultSuccess(int round, int size) {
        String output = "성공";
        if (round != size) {
            output = "실패";
        }
        System.out.println("게임 성공 여부: " + output);
    }

    public void printResultTotalMap(List<String> result, List<String> targetBridge) {
        System.out.println("최종 게임 결과");
        printMap(result, targetBridge);
    }
}
