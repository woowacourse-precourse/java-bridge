package view;

import bridge.BridgeMaker;
import domain.Bridge;
import domain.Result;
import enums.PrintEnum;
import enums.ResultMessage;

import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(
            Bridge bridge, int position
    ) {
        StringBuilder upStringBuilder = new StringBuilder().append(PrintEnum.START.getValue());
        StringBuilder downStringBuilder = new StringBuilder().append(PrintEnum.START.getValue());
        for(int i=0 ; i < position ; i++){
            buildMap(bridge.getUp(), bridge.getDown(), position, i , upStringBuilder, downStringBuilder);
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
        StringBuilder upStringBuilder = new StringBuilder().append(PrintEnum.START.getValue());
        StringBuilder downStringBuilder = new StringBuilder().append(PrintEnum.START.getValue());
        for(int i = 0 ; i < position ; i++){
            replaceX(bridge.getUp(), bridge.getDown(), i);
            buildMap(bridge.getUp(), bridge.getDown(), position, i, upStringBuilder, downStringBuilder);
        }
        System.out.println(upStringBuilder.toString());
        System.out.println(downStringBuilder.toString());
    }

    public void buildMap(List<String> up , List<String> down, int position, int i, StringBuilder upStringBuilder, StringBuilder downStringBuilder){
        if(i == position - 1 ) {
            upStringBuilder.append(up.get(i)).append(PrintEnum.END.getValue());
            downStringBuilder.append(down.get(i)).append(PrintEnum.END.getValue());
            return;
        }
        upStringBuilder.append(up.get(i)).append(PrintEnum.DIVIDER.getValue());
        downStringBuilder.append(down.get(i)).append(PrintEnum.DIVIDER.getValue());
    }

    public void replaceX(List<String> up, List<String> down, int i){
        if(Objects.equals(up.get(i), PrintEnum.X.getValue())) up.add(i, " ");
        if(Objects.equals(down.get(i), PrintEnum.X.getValue())) up.add(i , " ");
    }
}
