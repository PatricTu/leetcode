package q1041;

public class Solution1 {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int positionX = 0;
        int positionY = 0;
        int currentDirection = 0;
        for (char c : instructions.toCharArray()) {
            switch (c) {
                case 'G':
                    positionX += directions[currentDirection][0];
                    positionY += directions[currentDirection][1];
                    break;
                case 'R':
                    currentDirection = (currentDirection + 1) % 4;
                    break;
                case 'L':
                    currentDirection = (currentDirection + 3) % 4;
                    break;
            }
        }
        return (positionX == 0 && positionY == 0) || currentDirection != 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isRobotBounded("GGLLGG"));
    }
}
