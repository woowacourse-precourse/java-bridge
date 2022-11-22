package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> User_Bridge, String User_Move, boolean User_Move_isRight) {
        List<String> Upper = new ArrayList<>();
        List<String> Below = new ArrayList<>();
        for (String element : User_Bridge) {
            if (element.equals("U")) {
                Upper.add("O");
                Below.add(" ");
            } else if (element.equals("D")) {
                Upper.add(" ");
                Below.add("O");
            }
        }
        if (User_Move_isRight == false) {
            if (User_Move.equals("U")) {
                Upper.set(Upper.size() - 1, "X");
            } else if (User_Move.equals("D")) {
                Below.set(Below.size() - 1, "X");
            }
        }
        String result_Upper = "[ " + String.join(" | ", Upper) + " ]";
        String result_Below = "[ " + String.join(" | ", Below) + " ]";
        System.out.println(result_Upper);
        System.out.println(result_Below);
        System.out.println("");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println("최종 게임 결과");
    }
    }
}
