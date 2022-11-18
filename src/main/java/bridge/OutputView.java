package bridge;

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
    * 한 가지의 결과만 가져온다.
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
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> valueList) {
        System.out.println("최종 게임 결과");
        new BridgeGame().move(valueList);
        System.out.println();

        int attemption = valueList.size();
        List<String> value = valueList.get(attemption - 1);
        System.out.println("게임 성공 여부: " + getResult(value.get(1)));
        System.out.println("총 시도한 횟수: " + attemption);
    }

    /**
     *  게임 성공 여부를 가져온다.
     */
    private String getResult(String value)
    {
        if(value.equals("O"))
            return "성공";
        if(value.equals("X"))
            return "실패";
        return null;
    }
}
