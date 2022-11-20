package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static String resultStateUp = "[";
    private static String resultStateDown = "[";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String result) {
        char dir = result.charAt(0);
        char ox = result.charAt(1);
        addState(dir,ox);
        System.out.println(resultStateUp);
        System.out.println(resultStateDown);
    }

    public void printMap() {
        System.out.println(resultStateUp);
        System.out.println(resultStateDown);
    }

    private void addState(char dir, char ox) {
        changFormat();
        if (dir == 'U') {
            resultStateUp += " " + ox + " ]";
            resultStateDown += "   ]";
        } else if (dir == 'D') {
            resultStateDown += " " + ox + " ]";
            resultStateUp += "   ]";
        }
    }

    private void changFormat(){
        if (resultStateUp.length() >= 5){
            resultStateUp = resultStateUp.substring(0, resultStateUp.length()-1) + "|";
            resultStateDown = resultStateDown.substring(0, resultStateDown.length()-1) + "|";
        }
    }

    public void initOutputFormat() {
        resultStateUp = "[";
        resultStateDown = "[";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int tryCount) {
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
