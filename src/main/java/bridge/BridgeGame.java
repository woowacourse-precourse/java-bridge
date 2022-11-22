package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String > bridge;

    public static List<List<String>> getMap() {
        return map;
    }

    static List<List<String>> map= new ArrayList<>();

    public String  isSuccess() {
        if(success)
            return "성공";
        return "실패";
    }

    private boolean success=false;
    public Player getPlayer() {
        return player;
    }

    private Player player=new Player();

    public BridgeGame(List<String > bridge) {
        this.bridge = bridge;
    }


    private void initForm(List<List<String>> form) {
        for (int i = 0; i < form.size(); i++)
            for (int j = 0; j < player.getPosition(); j++)
                form.get(i).set(j," ");
    }


    public void makeMap(){
        initMap();
        for (int i = 0; i < map.size(); i++) {
            makeLine(map.get(i));
        }
        System.out.println(map);
    }

    private void makeLine(List<String> line) {
        for (int i = 0; i < bridge.size(); i++) {
            if(bridge.get(i).equals("U")) {
                line.add(i, "U");
                continue;
            }
            line.add(i,"D");
        }

    }

    private void initMap() {
        for (int i = 0; i < 2; i++)
            map.add(Collections.emptyList());
    }


    //틀림
    public boolean incorrect() {
        if(this.player.stage.name().equals(bridge.get(player.getPosition())))
            return true;
        return false;
    }

    //재시도
    public void retry() {
        this.player.backward();
    }

    //이동
    public void move(int readMoving) {
        this.player.forward();
        this.player.stage.getStage(readMoving);
    }

    //도착
    public boolean end() {
        if(player.getPosition()+1==bridge.size()){
            success=true;
            return true;
        }

        return false;
    }
}
