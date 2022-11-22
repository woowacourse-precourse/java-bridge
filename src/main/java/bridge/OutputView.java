package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private GenerateMessage generateMessage = new GenerateMessage();
    private final String success = "성공";
    private final String failure = "실패";
    
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        List<String> temp = generateMessage.get();
        System.out.println(temp.get(0));
        System.out.println(temp.get(1));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int attempts, boolean result) {
        System.out.println("최종 게임 결과");
        printMap();
        System.out.println("");
        if(result){
            System.out.println("게임 성공 여부: " + success);
        }
        if(!result){
            System.out.println("게임 성공 여부: " + failure);
        }
        System.out.println("총 시도한 횟수: " + attempts);
    }
    
}
