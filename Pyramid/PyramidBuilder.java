import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PyramidBuilder{

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        for (Integer elem: inputNumbers) {
            if (elem == null) {
                throw new CannotBuildPyramidException("");
            }
        }

        int pyramidDepth = getPyramidDepth(inputNumbers.size());
        int pyramidWidth = 2*pyramidDepth - 1;

        int[][] pyramid = new int[pyramidDepth][pyramidWidth];

        Collections.sort(inputNumbers);

        int offset = 0;
        int curInputIdx = inputNumbers.size() - 1;
        for (int curRow = pyramidDepth - 1; curRow >= 0; curRow--) {
            int numbersUpdated = 0;
            int curColumn = pyramidWidth - 1;
            while (numbersUpdated < (curRow + 1)) {
                int elem = inputNumbers.get(curInputIdx);

                pyramid[curRow][curColumn - offset] = elem;

                numbersUpdated++;
                curInputIdx--;
                curColumn-=2;
            }

            offset++;

            System.out.println(Arrays.deepToString(pyramid));
        }

        return pyramid;
    }

    private static int getPyramidDepth(int inputSize) {
        int pyramidDepth = 0;
        while (inputSize > 0) {
            inputSize -= pyramidDepth;
            pyramidDepth++;
        }

        if (inputSize < 0) {
            throw new CannotBuildPyramidException("");
        } else {
            return pyramidDepth - 1;
        }
    }

}
