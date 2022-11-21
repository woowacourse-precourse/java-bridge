package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static String upState;
    static String downState;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @param userState     유저가 입력해온 U or D
     * @param continueGame  게임 종료 or 진행
     * @param isSuccess     종료 일때 성공 or 실패
     *
     */
    public void printMap(List<String> userState, boolean continueGame, boolean isSuccess) {
        initState();
        // 게임 상태를 판단하여 출력
        judgeGameStatement(userState, continueGame, isSuccess);
        // 게임 결과 출력
        printMapResult();

    }

    /**
     * 성공과 실패의 여부에 따라 각각 다른 출력을 제공
     * @param userState     유저가 입력해온 U or D
     * @param continueGame  게임 종료 or 진행
     * @param isSuccess     종료 일때 성공 or 실패
     */
    public static void judgeGameStatement(List<String> userState, boolean continueGame, boolean isSuccess) {
        if (continueGame) {
            printGaming(userState, userState.size(), isSuccess);
        }
        if (!continueGame && isSuccess) {
            printGaming(userState, userState.size(), isSuccess);
        }
        if (!continueGame && !isSuccess) {
            printWrongAndFail(userState, isSuccess);
        }
    }
    // 게임이 끝 AND 실패
    public static void printWrongAndFail(List<String> userState, boolean isSuccess) {
        printGaming(userState, userState.size(), isSuccess);
        replaceClose();
        isWrongFinished(userState);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> userState, boolean isSuccess, int totalCount) {
        initState();
        System.out.println("\n최종 게임 결과");
        printGaming(userState, userState.size(), isSuccess);
        if (!isSuccess) {
            replaceClose();
            isWrongFinished(userState);
        }
        printEndOfGame(isSuccess, totalCount);
    }

    // 최종 게임 결과 출력
    public void printEndOfGame(boolean isSuccess, int totalCount) {
        printMapResult();
        System.out.println("\n게임 성공 여부: " + isFail(isSuccess));
        System.out.println("총 시도한 횟수: " + totalCount);
    }

    // ] 제거 메서드
    public static void replaceClose() {
        upState = upState.replace("]", "");
        downState = downState.replace("]", "");
    }
    public static void printMapResult() {
        System.out.println(upState);
        System.out.println(downState);
    }

    // 게임 종료 판단 실패 or 성공
    public static String isFail(boolean isSuccess) {
        if (isSuccess) {
            return "성공";
        }
        if (!isSuccess) {
            return "실패";
        }
        return "오류";
    }

    public static void printGaming(List<String> userState, int size, boolean continueGame) {
        for (int i = 0; i < size; i++) {
            isWord(userState.get(i));
            isFinish(userState.size(), i, continueGame);
        }
    }

    // 괄호를 닫을 지 추가하는 | 를 넣을 지 고미나는 메서드
    public static void isFinish(int userStateSize, int i, boolean continueGame) {
        // 게임 끝났는데 게임 진행중 or 실패
        finishedStatement(userStateSize, i, continueGame);
        // 게임 진행중인데 게임 실패
        notFinishedStatement(userStateSize, i, continueGame);

    }

    public static void finishedStatement(int userStateSize, int i, boolean continueGame) {
        if (userStateSize - 1 == i && continueGame) {
            isFinished();
        }
        // 맨 마지막인데 성공일 때
        if (userStateSize - 1 == i && !continueGame) {
            isFinished();
        }
    }

    public static void notFinishedStatement(int userStateSize, int i, boolean continueGame) {
        if (userStateSize - 1 != i && !continueGame) {
            isNotFinished();
        }
        // 게임 진행중에 성공
        if (userStateSize - 1 != i && continueGame) {
            isNotFinished();
        }
    }

    public void initState() {
        upState = "[";
        downState = "[";
    }

    public static void isWrongFinished(List<String> userState) {
        if (userState.get(userState.size() - 1).equals("U")) {
            upState += " X ]";
            downState += "   ]";
        }
        if (userState.get(userState.size() - 1).equals("D")) {
            upState += "   ]";
            downState += " X ]";
        }
    }

    public static void isU() {
        upState += " O ";
        downState += "   ";
    }

    public static void isWord(String userStateWord) {
        if (userStateWord == "U") {
            isU();
        }
        if (userStateWord == "D") {
            isD();
        }
    }

    public static void isD() {
        upState += "   ";
        downState += " O ";
    }

    public static void isFinished() {
        upState += "]";
        downState += "]";
    }

    public static void isNotFinished() {
        upState += "|";
        downState += "|";
    }
}