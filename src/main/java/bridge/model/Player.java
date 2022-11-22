package bridge.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Player {
    private List<String> playerBridge;

    public Player(){
        if(playerBridge == null) playerBridge = new ArrayList<>();
    }

    public void movePlayerBridge(String input){
        playerBridge.add(input);
    }

    public void resetPlayerBridge(){
        playerBridge.clear();
    }

    public int positionPlayerBridge(){
        return playerBridge.size();
    }

    public boolean compareBridge(Bridge gameBridge){
        return gameBridge.checkEqual(playerBridge);
    }

    public boolean isSame(Bridge gameBridge){
        return gameBridge.isSame(playerBridge);
    }

    public String toString(boolean isRight){
        List<List<String>> twoBridge = new ArrayList<>();

        AtomicInteger index = new AtomicInteger();
        AtomicInteger index1 = new AtomicInteger();

        if(!isRight) {
            twoBridge.add(playerBridge.stream().map(s -> {
                int num = index.getAndIncrement();
                if (s.equals("D")) return " ";
                if (num == (playerBridge.size() - 1) && s.equals("U")) return "X";
                return "O";
            }).collect(Collectors.toList()));

            twoBridge.add(playerBridge.stream().map(s -> {
                int num = index1.getAndIncrement();
                if (s.equals("U")) return " ";
                if (num == (playerBridge.size() - 1) && s.equals("D")) return "X";
                return "O";
            }).collect(Collectors.toList()));
        }else{
            twoBridge.add(playerBridge.stream().map(s -> {
                if (s.equals("D")) return " ";
                return "O";
            }).collect(Collectors.toList()));

            twoBridge.add(playerBridge.stream().map(s -> {
                if (s.equals("U")) return " ";
                return "O";
            }).collect(Collectors.toList()));
        }

        return twoBridge.stream().map(s->s.stream().collect(Collectors.joining(" | ","[ "," ]"))).collect(Collectors.joining("\n"));
    }
}
