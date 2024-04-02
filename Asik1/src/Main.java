import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static int printMin(int n , int mn) { // complexity O(n)

        if(n == 0){
            return mn;
        }

        int a = sc.nextInt();

        if(a < mn){
            mn = a;
        }

        return printMin(n-1, mn);

    }

    private static double printAvg(int n , double sum , int sz) { // complexity O(n)

        if(n == 0){
            return sum / sz;
        }

        int a = sc.nextInt();

        sum += a;

        return printAvg(n-1, sum , sz);

    }

    public static double printAvg(int n) { // complexity O(n)
        int sum = 0;
        int sz = n;
        return printAvg(n, sum , sz);
    }

    private static boolean isPrimeRec(int n , int limit , int i) { // complexity O(sqrt(n))
        if(n == 1){
            return false;
        }

        if(i > limit){
            return true;
        }

        if(n % i == 0){
            return false;
        }

        return isPrimeRec(n, limit, i+1);

    }

    public static String isPrimeRec(int n) { // complexity O(sqrt(n))
        if(n == 1){
            return "Composite";
        }

        return isPrimeRec(n, (int)Math.sqrt(n), 2)? "Prime" : "Composite";
    }


    public static int facorialOfN(int n) { //complexity O(n)
        if(n == 1){
            return 1;
        }

        return n * facorialOfN(n-1);
    }

    public static int fibonacci(int position) { //complexity O(2^n)
        if (position == 0) return 0;
        if (position == 1) return 1;

        return fibonacci(position - 2) + fibonacci(position - 1);
    }

    private static int nPowerM(int n , int m , int ans) { //complexity O(m)
        if(m == 0){
            return ans;
        }

        ans *= n;

        return nPowerM(n, m-1, ans);
    }

    public static int nPowerM(int n , int m){ //complexity O(m)
        int ans = 1;
        return nPowerM(n, m, ans);
    }




    public static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
    private static void allPermutationsOfString(String s , int i) { //complexity O(n!)
        if(i == s.length()){
            System.out.println(s);
            return;
        }

        for(int j=i;j<s.length();j++){
            s = swap(s, i, j);
            allPermutationsOfString(s, i+1);
            s = swap(s, i, j);
        }

    }

    public static void allPermutationsOfString(String s) { //complexity O(n!)
        allPermutationsOfString(s, 0);
    }


    private static boolean isOnlyDigits(String s , int i){

        if(i == s.length()){
            return true;
        }

        if(s.charAt(i) < '0' || s.charAt(i) > '9'){
            return false;
        }

        return isOnlyDigits(s, i+1);

    }

    public static String isOnlyDigits(String s) {
        return isOnlyDigits(s, 0)? "Yes" : "No";
    }


    public static int binomiamCoeffficient(int n ,  int k) { //complexity O(n)
        if(k == 0 || k == n){
            return 1;
        }

        return binomiamCoeffficient(n-1, k-1) + binomiamCoeffficient(n-1, k);
    }

    public static int GCDrec(int n , int m) { //complexity O(log(n))
        if(m == 0){
            return n;
        }

        return GCDrec(m, n % m);
    }





    public static void task1() {
        int n = sc.nextInt();
        System.out.println(printMin(n, Integer.MAX_VALUE));
    }

    public static void task2() {
        int n = sc.nextInt();
        System.out.println(printAvg(n));
    }

    public static void task3() {
        int n = sc.nextInt();
        System.out.println(isPrimeRec(n));
    }

    public static void task4() {
        int n = sc.nextInt();
        System.out.println(facorialOfN(n));
    }

    public static void task5() {
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }


    public static void task6() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(nPowerM(n, m));
    }

    public static void task7() {
        String s = sc.next();
        allPermutationsOfString(s);
    }

    public static void task8() {
        String s = sc.next();
        System.out.println(isOnlyDigits(s));
    }

    public static void task9() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(binomiamCoeffficient(n, k));
    }

    public static void task10() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(GCDrec(n, m));
    }

    public static void main(String[] args) {

        task1();

    }

}