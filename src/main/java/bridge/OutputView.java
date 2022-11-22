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
    static void printMap(List<String> playerList, List<String> BRIDGEANSWER) {
        List<String> lowerList = new ArrayList<>(), upperList = new ArrayList<>();
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).equals(BRIDGEANSWER.get(i))) {AddEqualCase(playerList.get(i), upperList, lowerList);}
            if (!playerList.get(i).equals(BRIDGEANSWER.get(i)))
            { AddNotEqualCase(playerList.get(i), upperList, lowerList); }
        }
        ConvertCommaToBar(upperList, lowerList);
    }

    private static void ConvertCommaToBar(List<String> upperList, List<String> lowerList) {
        StringBuffer upperString = new StringBuffer(upperList.toString().replace(", ", "|"));
        StringBuffer lowerString = new StringBuffer(lowerList.toString().replace(", ", "|"));
        String(upperString.toString());
        String(lowerString.toString());
    }

    private static void AddEqualCase(String letter, List<String> upperList, List<String> lowerList) {
        if (letter.equals("U"))
        { upperList.add(" O ");
            lowerList.add("   "); }
        if (letter.equals("D"))
        { upperList.add("   ");
            lowerList.add(" O "); }
    }

    private static void AddNotEqualCase(String letter, List<String> upperList, List<String> lowerList) {
        if (letter.equals("U"))
        { upperList.add(" X ");
            lowerList.add("   "); }
        if (letter.equals("D"))
        { upperList.add("   ");
            lowerList.add(" X "); }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    static void printResult(Boolean success, Integer tryCount) {
        String result = SuccessConvert(success);
        String("최종 게임 결과");
        String("게임 성공 여부: "+result);
        String("총 시도한 횟수: "+tryCount);
    }

    static void String(String message) {
        System.out.println(message);
    }

    private static String SuccessConvert(Boolean boo) {
        String result = "";
        if (boo.equals(true)) { result = "성공"; }
        if (boo.equals(false)) { result = "실패"; }
        return result;
    }
}
