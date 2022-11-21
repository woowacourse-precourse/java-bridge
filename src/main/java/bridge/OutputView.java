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
    public static void printMap(List<String> playerList, List<String> BRIDGEANSWER) {
        List<String> lowerList = new ArrayList<>();
        List<String> upperList = new ArrayList<>();

        for (int i = 0; i < playerList.size(); i++) {
            if (BRIDGEANSWER.get(i).equals(playerList.get(i))) {
                if (BRIDGEANSWER.get(i).equals("0")) {
                    lowerList.add(" O ");
                    upperList.add("   ");
                }
                if (BRIDGEANSWER.get(i).equals("1")) {
                    lowerList.add("   ");
                    upperList.add(" O ");
                }
            }
            if (!BRIDGEANSWER.get(i).equals(playerList.get(i))) {
                if (playerList.get(i).equals("0")) {
                    lowerList.add(" X ");
                    upperList.add("   ");
                }
                if (playerList.get(i).equals("1")) {
                    lowerList.add("   ");
                    upperList.add(" X ");
                }
            }
        }

        StringBuffer upperString = new StringBuffer(upperList.toString().replace(",", "|"));
        upperString.insert(0, "[");
        upperString.insert(-1, "]");

        StringBuffer lowerString = new StringBuffer(upperList.toString().replace(",", "|"));
        lowerString.insert(0, "[");
        lowerString.insert(-1, "]");

        System.out.println(upperList);
        System.out.println(lowerList);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public static void String(String message) {
        System.out.println(message);
    }
}
