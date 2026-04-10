public class _134_GasStation {


    public static int canCompleteCircle(int[] gas,int[] cost){

        int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];

             currentTank += gas[i] - cost[i];

            if (currentTank < 0) {
                startIndex = i + 1;
                currentTank = 0;
            }
        }

        if (totalGas < totalCost) {
            return -1;
        }
        
        return startIndex;
    }

    public static void main(String[] args){

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(canCompleteCircle(gas, cost));

    }


}
