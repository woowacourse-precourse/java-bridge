package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @param bridge Up 다리인지, Down 다리인지 알려준다.
     * @param valueList 현재까지 건넌 다리의 결과
     * @return 정해진 형식에 맞춰 string에 담아서 결과를 넘긴다.
     *
     */
    public String printMap(String bridge, List<List<String>> valueList) {
        String result ="[";
        for(int i = 0; i < valueList.size(); i++) {
            result += printValue(bridge, valueList.get(i));
            if(i + 1 != valueList.size())
                result += "|";
        }
        result += "]";
        return result;
    }

    /**
     * 특정 위치 다리의 결과를 가져온다.
     * @param bridge Up 다리인지, Down 다리인지 알려준다.
     * @param value 특정 위치 다리의 결과
     * @return bridge 일때, 그 다리를 건넜다면 결과를 반환해준다.
     *         bridge 일때, 그 다리를 건너지 않았다면 공백을 반환해준다.
    */
    private String printValue(String bridge, List<String> value) {
        if(bridge.equals(value.get(0)))
            return " " + value.get(1) + " ";
        if(!bridge.equals(value.get(0)))
            return "   ";
        return null;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @param valueList 최종 게임 결과를 가지고 있다.
     * @param attemption 지금까지 시도한 게임 횟수를 가지고 있다.
     */
    public void printResult(List<List<String>> valueList, int attemption) {
        System.out.println("최종 게임 결과");
        System.out.println(printMap("U", valueList)); //Upside 게임 결과 출력
        System.out.println(printMap("D", valueList)); //Downside 게임 결과 출력
        System.out.println();

        System.out.println("게임 성공 여부: " + getResult(valueList.get(valueList.size() - 1))); //가장 마지막 결과로 확인해야 함
        System.out.println("총 시도한 횟수: " + attemption);
    }

    /**
     *  게임 성공 여부를 가져온다.
     * @param value 가장 마지막에 진행한 게임 결과를 가지고 있다.
     * @return 게임 결과가 'O'이면 '성공'을, 'X'이면 '실패'를 반환한다.
     */
    public String getResult(List<String> value)
    {
        if(value.get(1).equals("O"))
            return "성공";
        if(value.get(1).equals("X"))
            return "실패";
        return null;
    }
}
