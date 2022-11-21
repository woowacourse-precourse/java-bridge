package bridge.view;

import java.lang.ref.PhantomReference;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * <P>
 * 1. 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * 2. OutputView의 패키지는 변경할 수 있다.
 * 3. OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 4. 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String RESULT_MESSAGE = "\n게임 성공 여부: ";
    public static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: ";
    public static final String FINAL_MAP_MESSAGE = "\n최종 게임 결과";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> results) {
//        String str = results.get(0).toString();
//        System.out.println(str.replace(","," |").replace("NO","").replace("[", "[ ").replace("]"," ]"));
//        String str2 = results.get(1).toString();
//        System.out.println(str2.replace(","," |").replace("NO","").replace("[", "[ ").replace("]"," ]"));
        for(List<String> result: results){
            String str = result.toString();
            System.out.println(str.replace(","," |").replace("NO","").replace("[", "[ ").replace("]"," ]"));
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> results,String gameResult, int tryCount) {
        System.out.println(FINAL_MAP_MESSAGE);
        printMap(results);
        System.out.println(RESULT_MESSAGE+gameResult);
        System.out.println(TRY_COUNT_MESSAGE+tryCount);
    }

    public void printStartMessage(){
        System.out.println(START_MESSAGE);
    }
}
