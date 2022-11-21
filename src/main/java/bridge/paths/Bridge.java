package bridge.paths;

import bridge.exceptions.CustomInternalOperationError;
import bridge.identifiers.Direction;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<Direction> securePath;
    private final int length;

    public Bridge(List<String> securePath, int length){
        validate(securePath, length);
        this.length = length;
        this.securePath = securePath.stream()
                .map(Direction::valueOf)
                .collect(Collectors.toList());
    }

    private void validate(List<String> securePath, int length){
        if(securePath == null || securePath.size() != length)
            throw new CustomInternalOperationError(
                    "다리 길이가 사용자가 입력한 길이와 다릅니다."
            );
    }

    public boolean checkCollapse(List<Direction> playerPath){
        int index = playerPath.size() - 1;
        return securePath.get(index).equals(playerPath.get(index));
    }
}
