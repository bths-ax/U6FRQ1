public class SoundRunner {
	public static void main(String[] args) {
		// made my own tests w the examples bc the testing replit wasnt posted
		Sound s1 = new Sound(new int[]
			{ 40, 2532, 17, -2300, -17, -4000, 2000, 1048, -420, 33, 15, -32, 2030, 3223 });
		Sound s2 = new Sound(new int[]
			{ 0, 0, 0, 0, -14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0 });

		System.out.println(s1.limitAmplitude(2000));
		int[] samples1 = s1.getSamples();
		for (int i = 0; i < samples1.length; i++)
			System.out.print(samples1[i] + " ");
		System.out.println();

		s2.trimSilenceFromBeginning();
		int[] samples2 = s2.getSamples();
		for (int i = 0; i < samples2.length; i++)
			System.out.print(samples2[i] + " ");
		System.out.println();
	}
}
