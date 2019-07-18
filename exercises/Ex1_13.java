import java.util.Arrays;
import java.util.Random;

class Ex1_13 {
    public static void main(String[] args) {
        Random random = new Random();
        byte alreadyChosen = -1;

        byte[] numbers = new byte[49];
        for (byte idx = 0; idx < 49; idx++) {
            numbers[idx] = (byte) (idx + 1);
        }

        byte[] winningNumbers = new byte[6];
        int winIdx = 0;
        while (winIdx < 6) {
            int numIdx = Math.floorMod(random.nextInt(), 49);
            byte choice = numbers[numIdx];
            if (choice != alreadyChosen) {
                winningNumbers[winIdx] = choice;
                numbers[numIdx] = alreadyChosen;
                winIdx++;
            }
        }
        Arrays.sort(winningNumbers);
        System.out.println(Arrays.toString(winningNumbers));
    }
}
