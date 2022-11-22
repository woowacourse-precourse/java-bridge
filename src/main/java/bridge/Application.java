package bridge;

import java.util.List;

public class Application {

    static InputView inputView;
    static OutputView outputView;
    static BridgeMaker bm;
    static BridgeGame bg;
    static User user;
    static boolean restart = false;

    public static void main(String[] args) {
        int trial = 0;

        initView();
        initBridge();
        user = new User();

        greetings();
        List<String> answer = init();
        System.out.println("answer = " + answer.toString());
        askUntilDone(answer, trial);
    }

    // 게임의 전체적인 흐름
    private static void askUntilDone(List<String> answer, int trial) {
        while (true) {
            userOneMove(answer);
            if (checkConditions(answer, trial)) {
                break;
            }
            if (restart) {
                trial += 1;
                restart = false;
            }
        }
    }

    private static void userOneMove(List<String> answer) {
        user = askUserMove();
        compareAndPrint(answer);
    }

    private static boolean checkConditions(List<String> answer, int trial) {
        if (checkSucceed(bg.move(answer, user), answer.size(), trial)) {
            return true;
        }
        if (checkGameOver(bg.move(answer, user))) {
            if (askAgain(trial, answer) == null) {
                return true;
            }
            restart = true;
        }
        return false;
    }

    private static User askAgain(int trial, List<String> answer) {
        if (tryAgain()) {
            return user = new User();
        }
        // Termination condition: 종료(Q)
        outputView.printResult(bg.move(answer, user), "실패", trial + 1);
        return null;
    }

    private static void compareAndPrint(List<String> answer) {
        List<List<String>> comparedResult = bg.move(answer, user);
        outputView.printMap(comparedResult);
    }

    private static User askUserMove() {
        try {
            String dir = inputView.readMoving();
            user.saveChoice(dir);
            return user;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askUserMove();
        }
    }

    private static void initBridge() {
        bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        bg = new BridgeGame();
    }

    private static void initView() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public static void greetings() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    // 다리 생성, 길이 초기 입력
    private static List<String> init() {
        try {
            int sz = inputView.readBridgeSize();
            List<String> moveAnswer = bm.makeBridge(sz);
            return moveAnswer;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return init();
        }
    }

    private static boolean tryAgain() {
        try {
            String cmd = inputView.readGameCommand();
            return bg.retry(cmd);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return tryAgain();
        }
    }

    // Termination condition: 실패(X)
    private static boolean checkGameOver(List<List<String>> result) {
        for (List<String> items : result) {
            String marker = items.get(0);
            if (marker.equals("X")) {
                return true;
            }
        }
        return false;
    }

    // Termination condition: 성공
    private static boolean checkSucceed(List<List<String>> result, int size, int trial) {
        if (result.size() == size) {
            if (result.get(size - 1).get(0).equals("O")) {
                trial++;
                outputView.printResult(result, "성공", trial);
                return true;
            }
        }
        return false;
    }
}
