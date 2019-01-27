public class Driver {
    public static void main(String... args){
        //var bc = new BalanceCheck("xxxyyyzzz");
        var bc = new BalanceCheck("aaabbbcccdddeeeffggg");

        bc.iterateString();
        boolean result = bc.checkBalance();
        System.out.println("Result = " + result);
    }
}
