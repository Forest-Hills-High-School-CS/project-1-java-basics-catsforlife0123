import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class ZhengFProj1 {
    public static void main(String[] args) {
        //part 1
        
        //3
        int int1 = 15;
        int int2 = 2;
        int sum = int1 + int2;
        System.out.println(sum);
        
        //4
        int int3 = 51;
        double d1 = 21.32D;
        double diff = (double)int3 - d1;
        System.out.println(diff);
        
        //5
        double d2 = 5.0D;
        double d3 = 3.9D;
        double quo = d2 / d3;
        System.out.println(quo);
        
        //6
        int int4 = 2;
        int int5 = 3;
        double d4 = 4.0D;
        double pro = int4 * int5 * d4;
        System.out.println(pro);
        
        //7
        String F = "Forest";
        String H = "hills";
        String FH = F + " " + H;
        System.out.println(FH);
        
        //8
        System.out.println("\"\\/\\/hat\" \n\"up?\"");
        
        //9
        int j = 2;
        int k = 3;
        int l = 4;
        int ans = j * (k + l);
        System.out.println("" + j + "(" + k + "+" + l + ") = " + ans);
        
        //part 2
        boolean use = true;
        double result = 0;

        while(use){
            String input = JOptionPane.showInputDialog("Enter an operation followed list of numbers seperated by commas");
            if (input == null) {
                break;
            }
            if (input.length() < 5) {
                JOptionPane.showMessageDialog(null, "Please enter an operation followed by at least 2 numbers that are seperated by commas");
                break;
            }
            int len = input.length();
            String op = input.substring(0, 1); //operation
            int comma = input.indexOf(","); //first comma
            String n1 = input.substring(comma + 1); //first num to end
            String n2 = n1.substring(0, n1.indexOf(",")); //start to first num
            int num1 = Integer.parseInt(n2); //frist num from String to int
            String num = n1.substring(n1.indexOf(",") + 1); //second num to end
            result = num1;

            int num2;
            while(num.length() > 0) {
                comma = num.indexOf(",");
                String numS;
                if (comma == -1) { //no ore commas
                    numS = num; //becomes last num
                    num = "";
                } 
                else {
                    numS = num.substring(0, comma); //gets the number
                    num = num.substring(comma + 1); //gets the comma after number to the end
                }

                num2 = Integer.parseInt(numS); //turns String to num
                if (op.equals("+")) {
                    result += num2;
                } else if (op.equals("-")) {
                    result -= num2;
                } else if (op.equals("/")) {
                    result /= num2;
                } else if (op.equals("*")) {
                    result *= num2;
                } else {
                    JOptionPane.showMessageDialog(null, "please enter an operation");
                }
            }

            JOptionPane.showMessageDialog(null, "Operation result is " + result);
            System.out.println(result);
            String[] options = new String[]{"yes", "no"}; //0 = yes, 1 = no
            num2 = JOptionPane.showOptionDialog(null, "Would you like to try again?", "Again", 0, 0, null, options, null);
            if (num2 != 0) {
                use = false;
                break;
            }
        }
    }
}
