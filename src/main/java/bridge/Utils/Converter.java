package bridge.Utils;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    /**
     * @param List 게임의 결과값에서 나오는 리스트
     * @return 리스트의 홀수번째 항만을 정리해서 리턴
     */
    public static List<String> getOddList(List<String> List) {
        List<String> oddList = new ArrayList<>();
        for (int i = 0; i < List.size(); i++) {
            if (i % 2 == 0) {
                oddList.add(List.get(i));
            }
        }
        return oddList;
    }

    /**
     * @param List 게임의 결과값에서 나오는 리스트
     * @return 리스트의 짝수번 째 항만을 정리해서 리턴
     */
    public static List<String> getEvenList(List<String> List) {
        List<String> evenList = new ArrayList<>();
        for (int i = 0; i < List.size(); i++) {
            if (i % 2 == 1) {
                evenList.add(List.get(i));
            }
        }
        return evenList;
    }


}
