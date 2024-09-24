package dsa.queue;

import java.util.*;

public class OpenLock {

    public static String prevComb(String comb, int pos){
        char[] charComb = comb.toCharArray();
        charComb[pos] = charComb[pos] == '0' ? '9' : (char) (charComb[pos] - 1);
        return new String(charComb);
    }

    public static String nextComb(String comb, int pos){
        char[] charComb = comb.toCharArray();
        charComb[pos] = charComb[pos] == '9' ? '0' : (char) (charComb[pos] + 1);
        return new String(charComb);
    }


    public static int openLock(String[] deadends, String target){
        int noOfTurns = 0;
        Set<String> visited = new HashSet<>(List.of(deadends));
        if (visited.contains("0000")) return -1;
        Queue<String> pending = new LinkedList<>();
        pending.add("0000");
        visited.add("0000");
        while(!pending.isEmpty()){
            int currentLevelNodesCount = pending.size();
            for(int i = 0; i < currentLevelNodesCount; i++){
                String comb = pending.poll();
                if (comb.equals(target)) return noOfTurns;
                for (int turn = 0; turn < 4; turn++){
                    String nextC = nextComb(comb, turn);
                    if (!visited.contains(nextC)){
                        pending.add(nextC);
                        visited.add(nextC);
                    }
                    String prevC = prevComb(comb, turn);
                    if (!visited.contains(prevC)){
                        pending.add(prevC);
                        visited.add(prevC);
                    }
                }
            }
            noOfTurns++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        System.out.println(openLock(deadends, "0202")==6);

        deadends = new String[]{"8888"};
        System.out.println(openLock(deadends, "0009")==1);

        deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        System.out.println(openLock(deadends, "8888")==-1);


    }
}
