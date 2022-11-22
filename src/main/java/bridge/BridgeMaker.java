package bridge;

import bridge.EnumClass.EnumCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(bridgeNumberGenerator.generate());
        }
        return result.stream().map(this::mapToCommand).collect(Collectors.toList());
    }

    private String mapToCommand(int command){
        if(command == EnumCommand.Up.getWorth()){
            return EnumCommand.Up.getCommand();
        }
        if(command == EnumCommand.Down.getWorth()){
            return EnumCommand.Down.getCommand();
        }
        return null;
    }
}
