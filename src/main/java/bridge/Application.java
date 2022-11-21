package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bg = new BridgeGame();
        User user = new User();

        greetings();
        List<String> answer = init(inputView, bm);
        System.out.println("answer = " + answer.toString());
        moveUntilDone(user, bg, inputView, outputView, answer);
    }

    public static void greetings() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    // 다리 생성, 길이 초기 입력
    private static List<String> init(InputView inputView, BridgeMaker bm) {
        try {
            int sz = inputView.readBridgeSize();
            List<String> moveAnswer = bm.makeBridge(sz);
            return moveAnswer;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return init(inputView, bm);
        }
    }

    // 다리 건너기 성공할 때까지 게임 진행
    private static void moveUntilDone(User user, BridgeGame bg, InputView inputView, OutputView outputView, List<String> answer) {
        boolean done = false;
        boolean succeed = false;
        int trial = 0;
        while (true) {
            if (succeed) {
                break;
            }
            if (done) {
                trial++;
                if (bg.retry(inputView)) {
                    user = new User();
                    done = false;
                    continue;
                }
                outputView.printResult(bg.move(answer, user), "실패", trial);
                break; // Termination condition: 종료(Q)
            }
            done = userSingleMove(user, bg, inputView, outputView, answer);
            succeed = checkSucceed(bg.move(answer, user), outputView, answer.size(), trial);
        }
    }

    private static boolean userSingleMove(User user, BridgeGame bg, InputView inputView, OutputView outputView, List<String> answer) {
        try {
            String dir = inputView.readMoving();
            user.saveChoice(dir);
            List<List<String>> comparedResult = bg.move(answer, user);
            outputView.printMap(comparedResult);
            return checkGameOver(comparedResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return userSingleMove(user, bg, inputView, outputView, answer);
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
    private static boolean checkSucceed(List<List<String>> result, OutputView outputView, int size, int trial) {
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
