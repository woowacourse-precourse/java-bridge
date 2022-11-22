package view;

import bridge.BridgeMaker;
import domain.Bridge;
import domain.Result;
import enums.ResultMessage;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static final String divider = " | ";
    static final String start = "[ ";
    static final String end = " ]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(
            Bridge bridge, int position
    ) {
        StringBuilder upStringBuilder = new StringBuilder().append(start);
        StringBuilder downStringBuilder = new StringBuilder().append(start);
        List<String> up = bridge.getUp();
        List<String> down = bridge.getDown();
        for(int i=0; i < position ; i++){
            if(i == position-1) {
                upStringBuilder.append(up.get(i)).append(end);
                downStringBuilder.append(down.get(i)).append(end);
                continue;
            }
            upStringBuilder.append(up.get(i)).append(divider);
            downStringBuilder.append(down.get(i)).append(divider);

        }
        System.out.println(upStringBuilder.toString());
        System.out.println(downStringBuilder.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result, Bridge bridge, int position) {
        System.out.println(ResultMessage.RESULT_INTRO_TEXT.getText());
        if(result.getIsSuccess().equals(ResultMessage.FAIL.getText())) printMapWhenFail(bridge, position);
        if(result.getIsSuccess().equals(ResultMessage.SUCCESS.getText())) printMap(bridge,position);
        String resultString = new StringBuilder()
                .append(ResultMessage.GAME_SUCCESS_OR_FAIL.getText()).append(result.getIsSuccess()).append("\n")
                .append(ResultMessage.TOTAL_TRIAL_COUNT.getText()).append(result.getTrial()).append("\n")
                .toString();
        System.out.println(resultString);
    }

    public void printMapWhenFail(Bridge bridge, int position){
        StringBuilder upStringBuilder = new StringBuilder().append(start);
        StringBuilder downStringBuilder = new StringBuilder().append(start);
        List<String> up = bridge.getUp();
        List<String> down = bridge.getDown();
        for(int i=0; i <= position ; i++){
            if( up.get(i) == "X") up.add(i, " ");
            if( down.get(i) == "X") up.add(i , " ");
            if(i == position ) {
                upStringBuilder.append(up.get(i)).append(end);
                downStringBuilder.append(down.get(i)).append(end);
            }
            if(i < position){
                upStringBuilder.append(up.get(i)).append(divider);
                downStringBuilder.append(down.get(i)).append(divider);
            }
        }
        System.out.println(upStringBuilder.toString());
        System.out.println(downStringBuilder.toString());
    }
}
