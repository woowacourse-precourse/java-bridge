package bridge;

import java.util.Arrays;
import java.util.Objects;

public enum DirectionCommand {
    UPPERPASS("U",1),
    LOWERPASS("D",0);

    private final String directionCommand;
    private final Integer bridgeSafety;

    DirectionCommand(String directionCommand, Integer bridgeSafety) {
        this.directionCommand = directionCommand;
        this.bridgeSafety = bridgeSafety;
    }
    public String getDirectionCommand(){
        return directionCommand;
    }
    public Integer getBridge(){
        return bridgeSafety;
    }

    public String direction(Integer bridgeSafety){
        return Arrays.stream(values())
                .filter(command -> Objects.equals(command.bridgeSafety, bridgeSafety))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .directionCommand;
    }

    public static DirectionCommand of(final String directionCommand){
        return Arrays.stream(values())
                .filter(command -> command.directionCommand.equals(directionCommand))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


}
