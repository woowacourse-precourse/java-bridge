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
    public static void printMap(List<String> upBridge, List<String> downBridge) {
        for(int i=0 ; i<upBridge.size() ; i++){ System.out.print(upBridge.get(i));}
        System.out.println("");
        for(int i=0 ; i<downBridge.size() ; i++){ System.out.print(downBridge.get(i));}
        System.out.println("");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> upBridge, List<String> downBridge) {
        System.out.println("최종 게임 결과");
        for(int i=0 ; i<upBridge.size() ; i++){ System.out.print(upBridge.get(i));}
        System.out.println("");
        for(int i=0 ; i<downBridge.size() ; i++){ System.out.print(downBridge.get(i));}
        System.out.println("");
        if (upBridge.contains("X")||downBridge.contains("X")) {lose();}
        if (!upBridge.contains("X")&&!downBridge.contains("X")) {win();}
    }

    public static void startPrint() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void bridgeSizeInputPrint(){
        System.out.println("다리의 길이를 입력해 주세요.");
    }

    public static void retryPrint() {System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");}

    public static void userSelect() { System.out.println("이동할 칸을 선택해주세요. (위 : U, 아래 : D)"); }

    public static int validatorNonNumber(String input){
        int number;
        try{
            number = Integer.parseInt(input);
        } catch (IllegalArgumentException e){
            return 0;
        } return number;
    }
    public static int validatorNumberRange(int input) {
        try {
            if (input < 3 || input > 20) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 3 ~ 20 사이의 숫자를 입력해주세요.");
            return 0;
        }
        return input;
    }

    public static String validatorUserSelect(String user) {
        try {
            if (user.equals("D") || user.equals("U")) {return user;}
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] U 혹은 D만 입력해 주세요.");
            return "";
        }
    }

    public static String validatorRetryUserSelect(String user){
        try {
            if (user.equals("R") || user.equals("Q")) {return user;}
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] R 혹은 Q만 입력해 주세요.");
            return "";
        }
    }

    public static void printCount(int count){
        System.out.println("총 시도한 횟수: " + count);
    }
    public static void win(){
        System.out.println("게임 성공 여부: 성공");
    }

    public static void lose(){
        System.out.println("게임 성공 여부: 실패");
    }
}
