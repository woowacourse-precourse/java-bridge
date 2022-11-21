package bridge.Console;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView implements Output{

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     *     U,D 를  O | X 로 변환하여 출력한다.
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Override
    public void printMap(Map<String, List<String>> result) {
        Iterator<String> keys = result.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            printEachList(result.get(key));
        }
    }

    private void printEachList(List<String> strings) {
        System.out.print("[");
        for (int i = 0; i < strings.size(); i++) {
            if(i == strings.size()-1){
                System.out.println(" " + strings.get(i) + " ]");
                return;
            }
            System.out.print(" " + strings.get(i) + " |");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Override
    public void printResult(boolean isSuccess, Integer count) {
        if(isSuccess){
            System.out.println("게임 성공 여부: 성공");
        }else{
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + count);
    }
}