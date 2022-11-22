package bridge.domain.view;

import bridge.constants.Direction;
import bridge.constants.GuideSentences;
import bridge.domain.model.CrossRecord;
import bridge.domain.model.GameResultInformation;
import java.util.Map;

public class OutputView {

    public void printEmptyLine() {
        System.out.print("\n");
    }

    public void printStartGuide() {
        System.out.println(GuideSentences.START.getSentence());
        printEmptyLine();
    }

    public void printInputBridgeLengthGuide() {
        System.out.println(GuideSentences.INPUT_BRIDGE_LENGTH.getSentence());
    }

    public void printInputMoveDirectionGuide() {
        System.out.println(GuideSentences.INPUT_MOVING_DIRECTION.getSentence());
    }

    public void printMap() {
        Map<Direction, String> crossRecord = CrossRecord.getCrossedBridge();
        for (Direction BRIDGE_DIRECTION : Direction.values()) {
            String oneDirectionRecord = crossRecord.get(BRIDGE_DIRECTION);
            System.out.println(oneDirectionRecord);
        }
        printEmptyLine();
    }

    public void printRetryGuide() {
        System.out.println(GuideSentences.INPUT_RETRY.getSentence());
    }

    public void printResult() {
        printFinalRecord();
        printSuccessOrFail();
        printCountOfTry();
    }

    private void printFinalRecord() {
        System.out.println(GuideSentences.RESULT.getSentence());
        printMap();
    }

    private void printSuccessOrFail() {
        String sentence =
                GuideSentences.IS_SUCCESS.getSentence() +
                        GameResultInformation.getGameResult().getResult();
        System.out.println(sentence);
    }

    private void printCountOfTry() {
        String sentence =
                GuideSentences.COUNT_OF_TRY.getSentence() +
                        GameResultInformation.getCountOfTry();
        System.out.println(sentence);
    }
}
