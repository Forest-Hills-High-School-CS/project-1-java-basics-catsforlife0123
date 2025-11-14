
import javax.swing.JOptionPane;

public class ZhengFProj3{
    
    public static double distanceBetween(Point a, Point b){
        return Math.sqrt(Math.pow(b.getX()-a.getX(), 2) + Math.pow(b.getY()-a.getY(), 2)); //distance formula
    }
    
    public static Point midPoint(Point a, Point b){
        double x = (a.getX() + b.getX())/2; 
        double y = (a.getY() + b.getY())/2;
        Point mid = new Point(x,y);
        return mid;
    }
    
    public static double slope(Point a, Point b){
        return (b.getY()-a.getY())/(b.getX()-a.getX()); //(y2-y1)/(x2-x1)
    }
    
    public static boolean isScalene(Point a, Point b, Point c){
        double d1 = distanceBetween(a, b);
        double d2 = distanceBetween(a, c);
        double d3 = distanceBetween(b, c);
        if(d1 != d2 && d1 != d3 && d2 != d3) //all different distances
            return true;
        else
            return false;
    }
    
    public static boolean isIsosceles(Point a, Point b, Point c){
        double d1 = distanceBetween(a, b);
        double d2 = distanceBetween(a, c);
        double d3 = distanceBetween(b, c);
        if((d1 == d2) || (d1 == d3) || (d2 == d3)) //two sitances are same
            return true;
        else
            return false;
    }
    
    public static boolean isEquilateral(Point a, Point b, Point c){
        double d1 = distanceBetween(a, b);
        double d2 = distanceBetween(a, c);
        double d3 = distanceBetween(b, c);
        if((d1 == d2) && (d1 == d3) && (d2 == d3)) //all distances are same
            return true;
        else
            return false;
    }
    
    public static boolean isRight(Point a, Point b, Point c){
        double s1 = slope(a,b);
        double s2 = slope(a,c);
        double s3 = slope(b,c);
        if((s1 == -1/s2) || (s1 == -1/s3) || (s2 == -1/s3)) //see if there are negative reciprical slopes
            return true;
        else
            return false;
    }
    
    public static double getHypotenuse(Point a, Point b, Point c){
        boolean right = isRight(a,b,c);
        double sA = distanceBetween(a,b);
        double sB = distanceBetween(a,c);
        double sC = distanceBetween(b,c);
        if(right){
            if(sC > sA && sC > sB) //hyp is longest side
                return sC;
            else if(sB > sA && sB > sC)
                return sB;
            else
                return sA;
        }
        else
            return -1;
    }
    
    public static double getHeight(Point a, Point b, Point c){
        boolean iso = isIsosceles(a,b,c);
        boolean right = isRight(a,b,c);
        double hyp = getHypotenuse(a,b,c);
        double d1 = distanceBetween(a,b);
        double d2 = distanceBetween(a,c);
        double d3 = distanceBetween(b,c);
        if(iso && right){ 
            if(hyp == d1) //returns any leg thats not hyp
                return d2;
            else if(hyp == d2)
                return d3;
            else
                return d1;
        }
        else if(iso){
            double h;
            if(d1 == d2){ 
                Point mid = midPoint(b,c);
                h = distanceBetween(a,mid);
            }
            else if(d1 == d3){
                Point mid = midPoint(a,c);
                h = distanceBetween(b,mid);
            }
            else{
                Point mid = midPoint(a,b);
                h = distanceBetween(c,mid);
            }
            return h;
        }
        else if(right){
            if(d1 <= d2 && d1 <= d3){ //returns shortest leg
                return d1;
            }
            else if(d2 <= d2 && d2 <= d3){
                return d2;
            }
            else
                return d3;
        }
        else
            return -1;
    }
    
    public static void main(String [] args){
        String p1 = JOptionPane.showInputDialog("Enter first point pls (in the format (x,y)): ");
        String p2 = JOptionPane.showInputDialog("Enter second point pls (in the format (x,y)): ");
        String p3 = JOptionPane.showInputDialog("Enter third point pls (in the format (x,y)): ");
        
        int c1 = p1.indexOf(",");
        int c2 = p2.indexOf(",");
        int c3 = p3.indexOf(",");
        
        int len1 = p1.length();
        int len2 = p2.length();
        int len3 = p3.length();
        
        double p1x = Double.parseDouble(p1.substring(1,c1));
        double p1y = Double.parseDouble(p1.substring(c1+1,len1-1));
        double p2x = Double.parseDouble(p2.substring(1,c2));
        double p2y = Double.parseDouble(p2.substring(c2+1,len2-1));
        double p3x = Double.parseDouble(p3.substring(1,c3));
        double p3y = Double.parseDouble(p3.substring(c3+1,len3-1));
        
        Point one = new Point (p1x, p1y);
        Point two = new Point (p2x, p2y);
        Point three = new Point (p3x, p3y);
        System.out.println("Your triangle is: A" + one + ", B" + two + ", C" + three + " u_u\n-------------------------------------------------------------------");
        
        //triangle types
        boolean sca = isScalene(one, two, three);
        if(sca)
            System.out.println("ABC is scalene >_<\n(all the sides are different lengths)\n-------------------------------------------------------------------");
        else
            System.out.println("ABC is NOT scalene -_-\n(two or more of the sides are the same length)\n-------------------------------------------------------------------");
        
        boolean iso = isIsosceles(one, two, three);
        if(iso)
            System.out.println("ABC is isosceles :>\n(two more more of the sides are the same length)\n-------------------------------------------------------------------");
        else
            System.out.println("ABC is NOT isosceles :<\n(all the sides are different lengths)\n-------------------------------------------------------------------");
        
        boolean equ = isEquilateral(one, two, three);
        if(equ)
            System.out.println("ABC is equilateral >o<\n(all the sides are the same length)\n-------------------------------------------------------------------");
        else
            System.out.println("ABC is NOT equilateral xOx\n(not all the sides are the same length)\n-------------------------------------------------------------------");
        
        boolean right = isRight(one, two, three);
        double hyp = 0;
        if(right){
            System.out.println("ABC is a right triangle :)\n(two of the slopes are negative reciprocals of each other)\n-------------------------------------------------------------------");
            hyp = getHypotenuse(one, two, three);
        }
        else
            System.out.println("ABC is NOT a right triangle :(\n(none of the slopes are negative reciprocals of each other)\n-------------------------------------------------------------------");
        
        //other stuff
        double h = getHeight(one, two, three);
        if(h != -1)
            System.out.println("The height of ABC is " + h + " ^_^\n-------------------------------------------------------------------");
        
        if(right)
            System.out.println("The hypotenuse of ABC is " + hyp + " ^o^\n-------------------------------------------------------------------");
        System.out.println("The end *-*");
    }
}