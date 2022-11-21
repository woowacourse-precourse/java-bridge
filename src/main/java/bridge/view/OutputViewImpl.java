package bridge.view;

import bridge.data.dto.responseDto.FinalResultResponseDto;
import bridge.data.dto.responseDto.InGameCommandResponseDto;
import bridge.type.MapComponentType;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class OutputViewImpl implements OutputView{

    private static final String MAP_HEAD = "[ ";
    private static final String MAP_DELIMITER = " | ";
    private static final String MAP_TAIL = " ]";
    private static final String MAP_O_MARK = "O";
    private static final String MAP_X_MARK = "X";
    private static final String MAP_BLANK = " ";


    @Override
    public void printMessage(Object message) {
        System.out.println();
        System.out.println(message.toString());
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
                .collect(Collectors.joining(MAP_DELIMITER)));
    }

    private String getOOrBlank(boolean isMatch) {
        if (isMatch) {
            return MAP_O_MARK;
        }
        return MAP_BLANK;
    }

    private String getLastElementAddedRow(Entry<String, String> lineEntry, InGameCommandResponseDto responseDto) {
        String baseLine = lineEntry.getValue() + MAP_DELIMITER;
        if (lineEntry.getKey().equals(responseDto.getLastMove())) {
            if (responseDto.isPlayerDead()) {
                return baseLine + MAP_X_MARK;
            }
            return baseLine + MAP_O_MARK;
        }
        return baseLine + MAP_BLANK;
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
    }

    public static void main(String[] args) {
        OutputView outputView = new OutputViewImpl();
        outputView.printMap(new InGameCommandResponseDto(
                List.of("U", "U", "D", "U"),
                List.of("U", "U", "D", "D")
        ));
    }
}
