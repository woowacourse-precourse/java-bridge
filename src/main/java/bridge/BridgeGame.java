package bridge;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputview = new InputView();
    OutputView outputview = new OutputView();

    public static String status = "성공";
    public static int count = 1;
    public static int retryornot = 1;

    public void start() {
        BridgeMaker bridgemaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> result = new ArrayList<>();

        outputview.printStart();
        int size = inputview.readBridgeSize();
        BridgeInform bridgeinform = new BridgeInform(size);
        List answer = bridgemaker.makeBridge(bridgeinform.getSize());

        restartGame(size, bridgeinform, result, answer);
        if(retryornot != 2) {
            outputview.printGameResult(result);
        }
        outputview.printStatusResult(status);
        outputview.printTimesResult(count);
    }

    public void restartGame(int size, BridgeInform bridgeinform, List<String> result, List answer) {
        List<String> copy = new ArrayList<>();
        for(int times = 0; times < size; times++) {
            if(retryornot == 1) {
                times = 0;
                retryornot = 0;
            }
            if(retryornot == 2) {
                outputview.printGameResult(copy);
                break;
            }
            bridgeinform.setDirection(inputview.readMoving());
            move(bridgeinform.getDirection(), answer, result);
            copy.addAll(result);
            outputview.printMap(result);
            if(times != size-1) {
                result.clear();
            }
        }
    }

    //사용자가 칸을 이동할 때 사용하는 메서드
    //이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
    public void move(List<String> moving, List<String> answer, List<String> result) {
        String[] upcompare = new String[moving.size()];
        String[] downcompare = new String[moving.size()];
        for(int direction = 0; direction < moving.size(); direction++) {
            if(moving.get(direction).equals(answer.get(direction))) {
                upcompare = upLine(moving, direction, upcompare);
                downcompare = downLine(moving, direction, downcompare);
            }
            if(moving.get(direction).equals(answer.get(direction)) == false) {
                upNotEqual(moving, direction, upcompare);
                downNotEqual(moving, direction, downcompare);
            }
        }
        result.add(drawLine(upcompare));
        result.add(drawLine(downcompare));
        if(status.equals("실패")) {
            retry();
        }
    }

    public void upNotEqual(List<String> moving, int direction, String[] upcompare) {
        if(moving.get(direction).equals("U")){
            upcompare[direction] = "X";
        }
        if(moving.get(direction).equals("D")){
            upcompare[direction] = " ";
        }
        status = "실패";
    }

    public void downNotEqual(List<String> moving, int direction, String[] downcompare) {
        if(moving.get(direction).equals("D")){
            downcompare[direction] = "X";
        }
        if(moving.get(direction).equals("U")){
            downcompare[direction] = " ";
        }
        status = "실패";
    }

    public String[] upLine(List<String> moving, int direction, String[] compare) {
        if(moving.get(direction).equals("U")) {
            compare[direction] = "O";
        }
        if(moving.get(direction).equals("D")) {
            compare[direction] = " ";
        }
        return compare;
    }

    public String[] downLine(List<String> moving, int direction, String[] compare) {
        if(moving.get(direction).equals("U")) {
            compare[direction] = " ";
        }
        if(moving.get(direction).equals("D")) {
            compare[direction] = "O";
        }
        return compare;
    }

    //사용자가 게임을 다시 시도할 때 사용하는 메서드
    //재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
    public void retry() {
        String quit = inputview.readExitCommand();
        if(quit.equals("R") == false && quit.equals("Q") == false) {
            throw new IllegalArgumentException("[ERROR]");
        }
        if(quit.equals("Q")) {
            retryornot = 2;
        }
        if(quit.equals("R")) {
            retryornot = 1;
        }
        count = count -1;
        count++;
    }

    public String drawLine(String[] compare) {
        StringBuilder sb = new StringBuilder("[ ");
        for(int character = 0; character < compare.length; character++) {
            sb.append(compare[character]);
            sb.append(" | ");
        }
        sb.delete(sb.length()-3, sb.length());
        sb.append(" ]");

        String result = String.valueOf(sb);
        return result;
    }
}
