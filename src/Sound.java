public class Sound
{
	/** the array of values in this sound; guaranteed not to be null */
	private int[] samples;

	/* constructor not shown */
	public Sound(int[] samples) {
		/* so i made one myself */
		this.samples = samples;
	}

	public int[] getSamples() { return samples; }

	/** Changes those values in this sound that have an amplitude
	 *  greater than limit. Values greater than limit are changed to
	 *  limit. Values less than -limit are changed to -limit.
	 *  The method returns the total number of values that were changed
	 *  in the array.
	 *
	 *  Precondition: limit >= 0
	 */
	public int limitAmplitude(int limit)
	{
		int changed = 0;
		for (int i = 0; i < samples.length; i++) {
			int ampl = Math.abs(samples[i]);
			if (ampl > limit) {
				samples[i] = samples[i] / ampl * limit;
				changed++;
			}
		}
		return changed;
	}

	/**  Removes all silence from the beginning of this sound.
	 *  Silence is represented by a value of 0.
	 *
	 *  Precondition: samples contains at least one nonzero value
	 *
	 *  Postcondition: the length of samples reflects the removal
	 *    of starting silence
	 */
	public void trimSilenceFromBeginning()
	{
		int i = 0;
		while (samples[i] == 0) i++;

		int[] trimmed = new int[samples.length - i];
		for (int j = i; j < samples.length; j++)
			trimmed[j - i] = samples[j];

		samples = trimmed;
	}
}
