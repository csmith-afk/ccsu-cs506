/*
public class Cs506hw1{

    public static void main(String args[]) {
        int[] x = {2,3,5};
        int y = 2;
        System.out.print("The last index is: ");
        System.out.println(findLast(x,y));
    }

public static int findLast (int[] x, int y) {
    for (int i =x.length-1; i >= 0; i--) {
        if (x[i] == y) {
            return i;
        }
    }
    return -1;
}
}
*/
/*
public class Cs506hw1{

    public static void main(String args[]) {
        int[] x = {0,1,0};
        System.out.print("The last index of 0 is: ");
        System.out.println(lastZero(x));
    }

    public static int lastZero (int[] x) {
        for (int i =x.length-1; i >= 0; i--) {
            if (x[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
*/
/*
public class Cs506hw1{

    public static void main(String args[]) {
        int[] x = {-4,2,0,2};
        System.out.print("The count of positive numbers is: ");
        System.out.println(countPositive(x));
    }

    public static int countPositive (int[] x) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > 0) {
                count++;
            }
        }
        return count;
    }
}
*/

public class Cs506hw1{

    public static void main(String args[]) {
        int[] x = {-3,-2,0,1,4};
        System.out.print("The count of odd and positive numbers is: ");
        System.out.println(oddOrPos(x));
    }

    public static int oddOrPos (int[] x) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (Math.abs(x[i])%2 == 1 || x[i] >0) {
                count++;
            }
        }
        return count;
    }
}