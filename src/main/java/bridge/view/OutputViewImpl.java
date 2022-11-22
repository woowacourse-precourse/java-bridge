package bridge.view;

import static bridge.type.OutputMessageType.*;

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

    @Override
    public void printMessage(Object message) {
        System.out.println("\n" + message.toString());
    }

    @Override
    public void printMap(InGameCommandResponseDto responseDto) {
        Map<String, String> movesMap = getMovesMap(responseDto);
        if (responseDto.isPlayerDead()) {
            String fixedRow = fixLastBlock(movesMap.get(responseDto.getLastMove()));
            movesMap.put(responseDto.getLastMove(), fixedRow);
        }
        System.out.println(stringifyMap(movesMap));
    }

    /**
     * 각각의 줄에 대한 플레이어의 선택을 문자열로 만들어 해시맵에 저장합니다.
     * @return {"U" : "O |   | O", "D" : "  | O |  "} 형태로 저장된 해시맵을 반환합니다.
     */
    private Map<String, String> getMovesMap(InGameCommandResponseDto responseDto) {
         return Arrays.stream(MapComponentType.values())
                .map(type -> getMovesPerRow(type.getMapComponent(), responseDto.getMoves()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    private Entry<String, String> getMovesPerRow(String component, List<String> moves) {
        return new SimpleEntry<>(component, moves.stream()
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

    /**
     * 마지막 선택을 O에서 X로 바꿉니다.
     */
    private String fixLastBlock(String row) {
        return row.substring(0, row.length() - 1) + MAP_X_MARK;
    }

    /**
     * MapComponentType이 선언 된 순서대로 지도를 출력합니다.
     */
    private String stringifyMap(Map<String, String> movesMap) {
        return Arrays.stream(MapComponentType.values())
                .map(MapComponentType::getMapComponent)
                .map(movesMap::get)
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
