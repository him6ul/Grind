package easy;

public class BuySellStock {

	public int maxProfit(int[] prices) {

		int buy = Integer.MAX_VALUE;
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {

			if (prices[i] < buy) {
				buy = prices[i];

			} else {

				int diff = prices[i] - buy;
				profit = Math.max(diff, profit);
			}
		}
		return profit;
	}

	public int maxProfitOld(int[] prices) {

		int max = 0;

		for (int i = 0; i < prices.length; i++) {

			int buy = prices[i];

			for (int j = i + 1; j < prices.length; j++) {

				int sell = prices[j];
				int tempMax = sell - buy;
				if (tempMax > max)
					max = tempMax;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println("___________________");

		BuySellStock buySellStock = new BuySellStock();

		int[] test1 = new int[] { 7, 1, 5, 3, 6, 4 };

		int result1 = buySellStock.maxProfit(test1);

		System.out.println("___________________ result1 -> " + result1);

		int[] test2 = new int[] { 7, 6, 4, 3, 1 };

		int result2 = buySellStock.maxProfit(test2);

		System.out.println("___________________ result2 -> " + result2);
	}

}
