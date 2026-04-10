public class _06_ZigzagConversion {

    static String convert(String str, int nunRows){

        if (nunRows == 1 || nunRows >= str.length()) {
            return str;
        }

        StringBuilder[] rows = new StringBuilder[nunRows];
        for (int i = 0; i < nunRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

        for (char c : str.toCharArray()) {
            rows[currRow].append(c);


            if (currRow == 0 || currRow == nunRows - 1) {
                goingDown = !goingDown;
            }
            // Changing Row
            currRow += goingDown ? 1 : -1;
        }
          
        // Join all rows

        StringBuilder result = new StringBuilder();
        
        for(StringBuilder row : rows){
            result.append(row);
        }

        return result.toString();

    }

    public static void main(String[] args) {
        
        
       
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        String result1 = convert(s1, numRows1);
        System.out.println("Input: " + s1 + ", Rows = " + numRows1);
        System.out.println("Output: " + result1);
        
       
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        String result2 = convert(s2, numRows2);
        System.out.println("Input: " + s2 + ", Rows = " + numRows2);
        System.out.println("Output: " + result2);  
    }
}
