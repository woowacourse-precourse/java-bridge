package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private StringBuilder sbUp = new StringBuilder();
    private StringBuilder sbDo = new StringBuilder();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        System.out.println(map);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printRequestUpDownMessage(){
        System.out.println("이동할 칸을 입력해주세요 (위: U, 아래: D)");
        System.out.println("");
    }


    public void printSuccess(List<String> bridge, int step){
        if(bridge.size() == step){
            System.out.println("게임 성공 여부 : 성공");
        }
        if(bridge.size() != step){
            System.out.println("게임 성공 여부 : 실패");
        }
    }

    public void printTryCount(int count){
        System.out.println("총 시도한 횟수: " + count);
    }
}
