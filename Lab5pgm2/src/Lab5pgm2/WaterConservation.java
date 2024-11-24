package Lab5pgm2;
import java.util.Scanner;

// Interface for Water Conservation System
interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}

// Abstract class implementing the interface
abstract class RainySeasonConservation implements WaterConservationSystem {
    public abstract int calculateTrappedWater(int[] blockHeights);
}

// Concrete class implementing water trapping logic
class CityBlockConservation extends RainySeasonConservation {
    @Override
    public int calculateTrappedWater(int[] blockHeights) {
        int n = blockHeights.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int trappedWater = 0;

        // Calculate left max heights
        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }

        // Calculate right max heights
        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - blockHeights[i];
        }

        return trappedWater;
    }
}

// Main class
public class WaterConservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CityBlockConservation conservation = new CityBlockConservation();

        // Accept user input for block heights
        System.out.println("Enter the number of blocks: ");
        int n = scanner.nextInt();
        int[] blockHeights = new int[n];

        System.out.println("Enter the heights of the blocks: ");
        for (int i = 0; i < n; i++) {
            blockHeights[i] = scanner.nextInt();
        }

        int trappedWater = conservation.calculateTrappedWater(blockHeights);

        System.out.println("Total Trapped Water = " + trappedWater);

        // Verify the test case with arr[] = {3, 0, 2, 0, 4}
        int[] testCase = {3, 0, 2, 0, 4};
        int testCaseResult = conservation.calculateTrappedWater(testCase);
        System.out.println("Test Case (arr[] = {3, 0, 2, 0, 4}): Trapped Water = " + testCaseResult);

        scanner.close();
    }
}
