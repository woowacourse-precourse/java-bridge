package bridge.view;

import static bridge.type.OutputMessageType.*;

import bridge.data.dto.responseDto.FinalResultResponseDto;
import bridge.data.dto.responseDto.InGameCommandResponseDto;
import bridge.type.MapComponentType;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class OutputViewImpl implements OutputView{

    @Override
    public void printMessage(Object message) {
        System.out.println("\n" + message.toString());
    }

    @Override
    public void printMap(InGameCommandResponseDto responseDto) {
        Map<String, String> answerMapRows = getAnswerMapRowsUntilLast(responseDto);
        for (Entry<String, String> row: answerMapRows.entrySet()) {
            answerMapRows.put(row.getKey(), getLastElementAddedRow(row, responseDto));
        }
        System.out.println(stringifyAnswerMapRows(answerMapRows));
    }

    private Map<String, String> getAnswerMapRowsUntilLast(InGameCommandResponseDto responseDto) {
         return Arrays.stream(MapComponentType.values())
                .map(type -> getAnswerMapEntry(type.getMapComponent(), responseDto))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    private Entry<String, String> getAnswerMapEntry(String component, InGameCommandResponseDto responseDto) {
        return new SimpleEntry<>(component, responseDto.getMoves().stream()
                .limit(responseDto.getMoves().size() - 1)
                .map(component::equals)
                .map(this::getOOrBlank)
                .collect(Collectors.joining(MAP_DELIMITER.toString())));
    }

    private String getOOrBlank(boolean isMatch) {
        if (isMatch) {
            return MAP_O_MARK.toString();
        }
        return MAP_BLANK.toString();
    }

    private String getLastElementAddedRow(Entry<String, String> lineEntry, InGameCommandResponseDto responseDto) {
        String baseLine = getBaseLine(lineEntry.getValue());
        if (lineEntry.getKey().equals(responseDto.getLastMove())) {
            if (responseDto.isPlayerDead()) {
                return baseLine + MAP_X_MARK;
            }
            return baseLine + MAP_O_MARK;
        }
        return baseLine + MAP_BLANK;
    }

    private String getBaseLine(String baseLine) {
        if (!baseLine.isEmpty()) {
            baseLine += MAP_DELIMITER;
        }
        return baseLine;
    }

    private String stringifyAnswerMapRows(Map<String, String> answerMapRows) {
        return Arrays.stream(MapComponentType.values())
                .map(MapComponentType::getMapComponent)
                .map(answerMapRows::get)
                .map(row -> MAP_HEAD + row + MAP_TAIL)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public void printResult(FinalResultResponseDto responseDto) {
        System.out.println(RESULT_HEAD);
        printMap(responseDto.getGameResult());
        System.out.println(getPassMessage(responseDto));
        System.out.println(getTryMessage(responseDto));
    }

    private String getPassMessage(FinalResultResponseDto responseDto) {
        return String.format(RESULT_PASS_OR_FAIL.toString(),
                getPassOrFail(responseDto.getGameResult().isGameCleared()));
    }

    private String getPassOrFail(boolean isPass) {
        if (isPass) {
            return RESULT_PASS.toString();
        }
        return RESULT_FAIL.toString();
    }

    private String getTryMessage(FinalResultResponseDto responseDto) {
        return String.format(RESULT_TRY_COUNT.toString(), responseDto.getTryCount());
    }
}
