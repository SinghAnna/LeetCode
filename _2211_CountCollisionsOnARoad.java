public class _2211_CountCollisionsOnARoad {

      public int countCollisions(String directions) {
        int collisions = 0;
        int i = 0;
        int n = directions.length();

        int j = n - 1;

        while (i < n && directions.charAt(i) == 'L') {
            i++;
        }

        while (j >= 0 && directions.charAt(j) == 'R') {
            j--;
        }

            for (int k = i; k <= j; k++) {
                if(directions.charAt(k) != 'S'){
                    collisions++;
                }
            }

        return collisions;
    }

    public static void main(String[] args) {


        _2211_CountCollisionsOnARoad collisionsOnARoad = new _2211_CountCollisionsOnARoad();

        String directins = "RRRRL";

        int collisions = collisionsOnARoad.countCollisions(directins);

        System.out.println(collisions);
    }
}
