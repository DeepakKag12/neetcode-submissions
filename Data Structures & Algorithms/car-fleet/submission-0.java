class Solution {

    class Pair {
        int pos;
        int speed;
        double time;

        Pair(int pos, int speed, double time) {
            this.pos = pos;
            this.speed = speed;
            this.time = time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double time = (double)(target - position[i]) / speed[i];
            list.add(new Pair(position[i], speed[i], time));
        }
        list.sort((a, b) -> b.pos - a.pos);
        int fleets = 0;
        double maxTime = 0;
        for (Pair p : list) {
            if (p.time > maxTime) {
                fleets++;
                maxTime = p.time;
            }
        }

        return fleets;
    }
}