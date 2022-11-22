package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

//    private String getUpDown(){
//        int direction = bridgeNumberGenerator.generate();
//        if(direction == 0)
//            return "D";
//        return "U";
//    }

//   public List<String> makeBridge(int size) {
//        List<String> bridge = new ArrayList<>(size);
//        for(int i = 0; i < size; ++i)
//            bridge.add(getUpDown());
//        return bridge;
//    }

       public List<String> makeBridge(int size) {
       return Stream.generate(bridgeNumberGenerator::generate)
               .limit(size)
               .map(Direction::toCommand)
               .collect(toList());
    }
}