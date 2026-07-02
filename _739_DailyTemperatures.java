public class _739_DailyTemperatures {

    public int[] dailytemp(int[] temp){
        int n = temp.length;
        int[] result = new int[n];
        int[] stack = new int[n];
        
        int top = -1;

        for(int i = n -1; i >= 0 ; i--){

            while (top >= 0 && temp[i] >= temp[stack[top]]) {
                top--;
            }

            result[i] = (top == -1) ? 0 : (stack[top] - i);
            stack[++top] = i;
            
        }


        return result;
    }

    public static void main(String[] args) {
        
        _739_DailyTemperatures dailyTemperatures = new _739_DailyTemperatures();
        int[] temp = {73,74,75,71,69,72,76,73};

        int[] res = dailyTemperatures.dailytemp(temp);

        for (int i : res) {
            System.out.print(i + " ");
        }
        
    }
}
