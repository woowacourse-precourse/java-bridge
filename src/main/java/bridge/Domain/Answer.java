package bridge.Domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import static java.util.stream.Collectors.toMap;
import static bridge.Domain.GameResult.PASS;
import static bridge.Domain.GameResult.FAIL;

public class Answer {
    public Map<TryCount, DirectionCommand> answerBridge;

    public Answer(List<String> bridge){
        this.answerBridge = getAnswerBridge(bridge);
    }

    public Map<TryCount,DirectionCommand> getAnswerBridge(List<String> bridge
    ){return makeAnswerBridge(TryCount.getTryCount(),getBridgeDirection(bridge));

    }

    public List<DirectionCommand> getBridgeDirection(List<String> bridge){
        return bridge.stream()
                .map(DirectionCommand::of)
                .collect(Collectors.toList());
    }

    public Map<TryCount,DirectionCommand> makeAnswerBridge(List<TryCount> tryCounts,List<DirectionCommand> directionCommands){
        return IntStream.range(0,directionCommands.size())
                .boxed()
                .collect(toMap(tryCounts::get, directionCommands::get));
    }

    public GameResult choiceResult(TryCount tryCount, DirectionCommand directionCommand){
        if(answerBridge.get(tryCount).equals(directionCommand)){
            return PASS;
        }
        return FAIL;
    }


}
