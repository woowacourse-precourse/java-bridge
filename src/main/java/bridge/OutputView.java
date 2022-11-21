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
    public void printMap(Map map) {
        for (String printableMap : map.getPrintableMap()){
            System.out.println(printableMap);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Map map, boolean isGameCleared, int totalAttempts) {
        String winOrLose = translateWinOrLose(isGameCleared);

        printComment(Comment.FINAL_RESULT);
        printMap(map);
        printComment(Comment.WIN_OR_LOSE, winOrLose);
        printComment(Comment.TOTAL_ATTEMPT, Integer.toString(totalAttempts));
    }

    /**
     * @param isGameCleared 게임 클리어 유무
     * @return true 는 "성공", false 는 "실패" 반환
     */
    private String translateWinOrLose(boolean isGameCleared) {
        if (isGameCleared) {
            return "성공";
        }
        return "실패";
    }

    /**
     * enum Comment value의 line 을 출력. 추가로 붙이고 싶은 문자열은 다음 인자로 넣는다.
     *
     * @param comment  enum Comment의 value
     * @param addition 추가로 붙이고 싶은 문자열
     */
    public void printComment(Comment comment, String... addition) {
        StringBuilder additionalInputs = new StringBuilder();
        for (String add : addition) {
            additionalInputs.append(add);
        }
        System.out.println(comment.line + additionalInputs);
    }

}
