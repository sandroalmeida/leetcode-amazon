package info.sandroalmeida;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    private static int helper(int[] coins, int rem, int[] count){
        if(rem < 0) return -1;
        if(rem == 0) return 0;
        if(count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for(int coin: coins){
            int res = helper(coins, rem - coin, count);
            if(res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins, 11));
    }
}
