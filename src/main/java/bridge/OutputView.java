package bridge;
import java.lang.String;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(String map, String Input, int count) {
        if (Input.equals("U")) {
            map = printUMap(map, "O", count);
        }
        if (Input.equals("D")) {
            map = printDMap(map, "O", count);
        }
        System.out.println(map);
        System.out.println();
        return map;
    }

    public String printFailMap(String map, String Input, int count) {
        if (Input.equals("U")) {
            map = printUMap(map, "X", count);
        }
        if (Input.equals("D")) {
            map = printDMap(map, "X", count);
        }
        System.out.println(map);
        System.out.println();
        return map;
    }

    public String printUMap(String map, String Input, int count) {
        String answer = "";
        if (count == 1) {
            answer = "[ " + Input + " ]\n[   ]";
            return answer;
        }
        return mergeUMap(map, Input, count);
    }

    public String mergeUMap(String map, String Input, int count) {
        String answer = "";
        answer += map.substring(0, (count - 1) * 4);
        answer += "| " + Input + " ]\n";
        int index = map.indexOf("[", 1);
        answer += map.substring(index, index + (count - 1) * 4);
        answer += "|   ]";
        return answer;
    }

    public String printDMap(String map, String Input, int count) {
        String answer = "";
        if (count == 1) {
            answer = "[   ]\n[ " + Input + " ]";
            return answer;
        }
        return mergeDMap(map, Input, count);
    }

    public String mergeDMap(String map, String Input, int count) {
        String answer = "";
        answer += map.substring(0, (count - 1) * 4);
        answer += "|   ]\n";
        int index = map.indexOf("[", 1);
        answer += map.substring(index, index + (count - 1) * 4);
        answer += "| " + Input + " ]";
        return answer;
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result,int count,boolean gameResult) {
        System.out.println("최종 게임 결과");
        System.out.println(result);
        System.out.println();
        if(gameResult){
            System.out.println("게임 성공 여부: 성공");}
        if(!gameResult){
            System.out.println("게임 성공 여부: 실패");}
        System.out.println("총 시도한 횟수: "+count);
    }

    public void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public void printInputSize(){
        System.out.println("다리의 길이를 입력해주세요.");
    }
    public void printMoving(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public void printReGame(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
