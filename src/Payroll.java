public class Payroll
{
	private int[] itemsSold; // number of items sold by each employee
	private double[] wages; // wages to be computed in part (b)

	public Payroll(int[] items)
	{
		itemsSold = items;
		wages = new double[items.length];
	}

	public double[] getWages() { return wages; }

	/*  Returns the bonus threshold as described in part (a).
	*/
	public double computeBonusThreshold()
	{
		int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int itemCnt : itemsSold) {
			sum += itemCnt;
			min = Math.min(min, itemCnt);
			max = Math.max(max, itemCnt);
		}
		return (double)(sum - min - max) / (itemsSold.length - 2); // - 1??? i need more sleep
	}

	/* Computes employee wages as described in part (b) and stores
	   them in wages. The parameter fixedWage represents the fixed
	   amount each employee is paid per day. The parameter
	   perItemWage represents the amount each employee is paid per
	   item sold.
	   */
	public void computeWages(double fixedWage, double perItemWage)
	{
		double bonusThres = computeBonusThreshold();
		for (int i = 0; i < wages.length; i++) {
			wages[i] = fixedWage + itemsSold[i] * perItemWage;
			if (itemsSold[i] > bonusThres) {
				wages[i] *= 1.10;
			}
		}
	}
}
