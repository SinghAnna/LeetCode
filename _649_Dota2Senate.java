import java.util.*;
import java.util.LinkedList;

public class _649_Dota2Senate {

    public String predictPartyVictory(String senate) {

        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        int n = senate.length();

        // Store index of each senator
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.add(i);
            } else {
                dQueue.add(i);
            }
        }

        // Simulate voting
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {

            int rIndex = rQueue.poll();
            int dIndex = dQueue.poll();

            if (rIndex < dIndex) {
                rQueue.add(rIndex + n);
            } else {
                dQueue.add(dIndex + n);
            }
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        _649_Dota2Senate obj = new _649_Dota2Senate();
        System.out.println(obj.predictPartyVictory("DDRRRR"));
    }
}
