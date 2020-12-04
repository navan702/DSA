public class Fibonocci {
    static int n1 = 0, n2 = 1, n3;
    public static void main(String[] args) {
        int fibLength = 10;
        System.out.print(n1+" "+n2);
        new Fibonocci().findFibonocci(fibLength - 2 );
    }

    private void findFibonocci(int num) {

        if(num > 0){
           n3 = n1 + n2 ;
            System.out.print(" " +n3);
            n1 = n2;
            n2 = n3;
            findFibonocci(num-1);
        }

    }
}
