import java.util.PriorityQueue;

public class _1792_MaximumAveragePassStudent {


    static class ClassInfo{
        int pass;
        int total;

        ClassInfo(int pass, int total){
            this.total = total;
            this.pass = pass;
        }

        // gain after adding one extra student
        double gain(){
             return (double)(pass + 1) / (total + 1) - (double) pass / total;
        }
    }

    public double maxAverageRatio(int[][] classes,int extraStudent){

        PriorityQueue<ClassInfo> pq = new PriorityQueue<>((a,b)-> Double.compare(b.gain(), a.gain()));

        //push all Classess
        for (int[] c : classes) {
            pq.add(new ClassInfo(c[0],c[1]));
        }

        //assign extra student greedly
        while (extraStudent-- > 0) {
            ClassInfo curr = pq.poll();
            curr.pass++;
            curr.total++;
            pq.add(curr);
        }

        // calculate final average
        double sum  = 0.0;
        for (ClassInfo c : pq) {
            sum += (double) c.pass / c.total;
        }

        return sum / classes.length;
    }

    public static void main(String[] args){
        _1792_MaximumAveragePassStudent avg = new _1792_MaximumAveragePassStudent();

           int[][] classes = {{1,2},{3,5},{2,2}};
        int extraStudents = 2;

        System.out.println(avg.maxAverageRatio(classes, extraStudents));

    }
}