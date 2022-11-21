package bridge.view;

import bridge.BridgeController;
import bridge.domain.GameResultType;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private String saveUpBuffer = "";
    private String saveDownBuffer = "";
    private final String PREFIX  = "[";
    private final String SUFFIX  = "]\n";
    private final String MIDFIX  = "|";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public OutputView(){
        saveUpBuffer += PREFIX;
        saveDownBuffer += PREFIX;
    }
    private void flushCall(){
        try {
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void startPrint(){
        try {
            bw.append("다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.\n");
            flushCall();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void gamePrint(){
        try {
            bw.append("이동할 칸을 선택해주세요. (위: U, 아래: D)\n");
            flushCall();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printRetry(){
        try {
            bw.append("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R,종료: Q)\n");
            flushCall();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void plusResult(GameResultType gameResultType, int index){
        if(index!=0) {
            saveUpBuffer+=MIDFIX;
            saveDownBuffer+=MIDFIX;
        }
        saveUpBuffer += gameResultType.getUpString();
        saveDownBuffer += gameResultType.getDownString();
    }
    public void printMap(){
        try {
            bw.append(saveUpBuffer).append(SUFFIX);
            bw.append(saveDownBuffer).append(SUFFIX).append("\n");
            flushCall();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResultType gameResultType) {
        try {
            bw.append("최종 게임 결과\n");
            printMap();
            bw.append("게임 성공 여부: ").append(gameResultType.getWinLoseKr());
            bw.append("총 시도한 횟수: "+ BridgeController.tryNumber);
            flushCall();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
