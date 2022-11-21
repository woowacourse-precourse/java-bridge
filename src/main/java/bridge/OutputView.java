package bridge;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    Application app = new Application();
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String[] printMap(List<String> bridge_input ,String choice, boolean same) {
        String[] Bridge_out = app.beforeMap(bridge_input);
        Bridge_out = app.addNow(Bridge_out,choice,same);
        Bridge_out[0] = "[" + Bridge_out[0] + "]";
        Bridge_out[1] = "[" + Bridge_out[1] + "]";
        System.out.println(Bridge_out[0]);
        System.out.println(Bridge_out[1]);
        return Bridge_out;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String[] Bridge_out,boolean yes_no,int count) {
        System.out.println("최종 게임 결과");
        System.out.println(Bridge_out[0]);
        System.out.println(Bridge_out[1]);
        if(yes_no) System.out.println("게임 성공 여부: 성공");
        else if(!yes_no) System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + count);
    }

    public void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    public void printFirst(){
        System.out.println("다리의 길이를 입력해 주세요.");
    }
    public void printSecond(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public void printRetry(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

}
