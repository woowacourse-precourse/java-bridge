package bridge;

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static final String WIN = "성공";
    public static final String LOSE = "실패";
    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final String BLANK = " ";
    public static final String CORRECT = "O";
    public static final String WRONG = "X";
    public static final String RETRY = "R";
    public static final String QUIT = "Q";
    public static final String ERROR_RETRYQUIT = "[ERROR] R(재시작) , Q(종료)중에 선택해주세요";

    public static String status = WIN;
    public static int count = 1;
    public static int retryornot = 0;

    BridgeGame() {

    }

    InputView inputview = new InputView();
    OutputView outputview = new OutputView();

    public void start() {
        BridgeMaker bridgemaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> result = new ArrayList<>();
        outputview.printStart();

        int size = inputview.readBridgeSize();
        BridgeInform bridgeinform = new BridgeInform(size);
        List answer = bridgemaker.makeBridge(bridgeinform.getSize());

        restartGame(size, bridgeinform, result, answer);
        if (retryornot != 2) {
            outputview.printGameResult(result);
        }
        outputview.printStatusResult(status);
        outputview.printTimesResult(count);
    }

    public void restartGame(int size, BridgeInform bridgeinform, List<String> result, List answer) {
        List<String> copy = new ArrayList<>();
        for (int times = 0; times < size; times++) {
            if (retryornot == 2) {
                break;
            }
            bridgeinform.setDirection(inputview.readMoving());
            move(bridgeinform.getDirection(), answer, result);
            copy.clear();
            copy.addAll(result);
            if (retryornot == 0) {
                outputview.printMap(result);
            }
            if (retryornot == 2) {
                outputview.printGameResult(result);
            }
            if (retryornot == 1) {
                count++;
                times = -1;
                bridgeinform.initDirection();
                retryornot = 0;
                status = WIN;
            }

            if (times != size - 1) {
                result.clear();
            }
        }
    }

    /**
     *사용자가 칸을 이동할 때 사용하는 메서드
     *이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
     public void move(List<String> moving, List<String> answer, List<String> result) {
        String[] upcompare = new String[moving.size()];
        String[] downcompare = new String[moving.size()];
        for (int direction = 0; direction < moving.size(); direction++) {
            if (moving.get(direction).equals(answer.get(direction))) {
                upcompare = upLine(moving, direction, upcompare);
                downcompare = downLine(moving, direction, downcompare);
            }
            if (moving.get(direction).equals(answer.get(direction)) == false) {
                upNotEqual(moving, direction, upcompare);
                downNotEqual(moving, direction, downcompare);
            }
        }
        result.add(drawLine(upcompare));
        result.add(drawLine(downcompare));
        if (status.equals(LOSE)) {
            outputview.printMap(result);
            retry();
        }
    }

    public void upNotEqual(List<String> moving, int direction, String[] upcompare) {
        if (moving.get(direction).equals(UP)) {
            upcompare[direction] = WRONG;
        }
        if (moving.get(direction).equals(DOWN)) {
            upcompare[direction] = BLANK;
        }
        status = LOSE;
    }

    public void downNotEqual(List<String> moving, int direction, String[] downcompare) {
        if (moving.get(direction).equals(DOWN)) {
            downcompare[direction] = WRONG;
        }
        if (moving.get(direction).equals(UP)) {
            downcompare[direction] = BLANK;
        }
        status = LOSE;
    }

    public String[] upLine(List<String> moving, int direction, String[] compare) {
        if (moving.get(direction).equals(UP)) {
            compare[direction] = CORRECT;
        }
        if (moving.get(direction).equals(DOWN)) {
            compare[direction] = BLANK;
        }
        return compare;
    }

    public String[] downLine(List<String> moving, int direction, String[] compare) {
        if (moving.get(direction).equals(UP)) {
            compare[direction] = BLANK;
        }
        if (moving.get(direction).equals(DOWN)) {
            compare[direction] = CORRECT;
        }
        return compare;
    }

    /**
     *사용자가 게임을 다시 시도할 때 사용하는 메서드
     *재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String quit = inputview.readExitCommand();
        if (quit.equals(RETRY) == false && quit.equals(QUIT) == false) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_RETRYQUIT);
                retry();
            }
        }
        if (quit.equals(QUIT)) {
            retryornot = 2;
        }
        if (quit.equals(RETRY)) {
            retryornot = 1;
        }
    }

    public String drawLine(String[] compare) {
        StringBuilder sb = new StringBuilder("[ ");
        for (int character = 0; character < compare.length; character++) {
            sb.append(compare[character]);
            sb.append(" | ");
        }
        sb.delete(sb.length() - 3, sb.length());
        sb.append(" ]");

        String result = String.valueOf(sb);
        return result;
    }
}
