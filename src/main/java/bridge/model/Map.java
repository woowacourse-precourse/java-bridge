package bridge.model;

import bridge.Move;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Map {
    static final int SIZE_OF_TILES = 2;
    private ArrayList<LinkedList<String>> map;
    private Iterator<String> answer;

    public Map(List<String> generatedMap) {
        ArrayList<LinkedList<String>> initializedMap = new ArrayList<>();
        for (int i = 0; i < SIZE_OF_TILES; i++) {
            initializedMap.add(new LinkedList<String>());
        }
        this.answer = generatedMap.iterator();
        this.map = initializedMap;
    }

    public boolean insertMove(Move move) {
        for (LinkedList<String> target : map) {
            target.add(" ");
        }
        LinkedList<String> target = map.get(move.getOrder());
        String compareResult = compareWithCurrentAnswer(move.getLocation());
        target.set(target.size() - 1,compareResult);
        if(compareResult=="O"){
            return true;
        }
        return false;
    }

    private String compareWithCurrentAnswer(String move) {
        if (move.equals(answer.next())) {
            return "O";
        }
        return "X";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<String> target : map) {
            sb.append("[ ");
            for (String temp1 : target) {
                sb.append(temp1 + " | ");
            }
            sb.replace(sb.length()-3,sb.length()," ]\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
