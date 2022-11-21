package bridge;

import java.util.List;

import static bridge.Constants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridgeAnswer, int bridgeSize, List<String> userCommand) {
        String upSentence = "[";
        String downSentence = "[";
        for(int size = 0; size < bridgeSize; size++){
            String command = userCommand.get(size);
            String answer = bridgeAnswer.get(size);
            boolean up = isUp(command);
            boolean down = isDown(command);
            upSentence += printAnswer(answer, bridgeSize, up);
            downSentence += printAnswer(answer, bridgeSize, down);
        }
        upSentence = removeDelimiter(upSentence) + "]";
        downSentence = removeDelimiter(downSentence) + "]";
        System.out.println(upSentence + '\n' + downSentence);
    }

    String removeDelimiter(String sentence){
        if(sentence.charAt(sentence.length() - 1) == '|'){
            sentence = sentence.substring(0, sentence.length() - 1);
        }
        return sentence;
    }

    String printAnswer(String answer, int bridgeSize, boolean isUpOrDown){
        if(!isUpOrDown){
            answer = "";
        }
        String combinedAnswer = " " + answer + " ";
        if(bridgeSize > 1){
            combinedAnswer += "|";
        }
        return combinedAnswer;
    }

    boolean isUp(String command){
        boolean up = false;
        if(command.equals("U")){
            up = true;
        }
        return up;
    }

    boolean isDown(String command){
        boolean down = false;
        if(command.equals("D")){
            down = true;
        }
        return down;
    }

    public void printInit(){
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printSelect(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridgeAnswer, int bridgeSize, List<String> userCommand,
                            int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(bridgeAnswer, bridgeSize, userCommand);

        String result = SUCCESS;
        System.out.println("게임 성공 여부: ");
        if(bridgeAnswer.contains("X")){
            result = FAIL;
        }
        System.out.println(result);
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    public void printRetry(String result){
        if(result.equals("X")){
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        }
    }
}
