package bridge.view;

import bridge.domain.GameResultType;
import bridge.domain.Result;

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
    public void printMap(GameResultType gameResultType){
        saveUpBuffer += gameResultType.getUpString();
        saveDownBuffer += gameResultType.getDownString();
        try {
            bw.append(saveUpBuffer + SUFFIX);
            bw.append(saveDownBuffer + SUFFIX);
            flushCall();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printInput(){
        try {
            bw.append("다리의 길이를 입력해주세요");
            flushCall();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {

    }
}
