package level3.자물쇠와열쇠;

public class 자물쇠와열쇠 {

    private static int[][] newLock;

    public boolean solution(int[][] key, int[][] lock) {

        int N = lock.length + (key.length - 1)*2;
        int offset = lock.length + key.length - 1;

        for (int i = 0; i < offset; i++) {
            for (int j = 0; j < offset; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    newLock = new int[N][N];
                    initLock(key.length - 1, lock);
                    rotateKey(i, j, key, dir);

                    boolean check = checkPlace(key.length - 1, lock);
                    if (check) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void initLock(int offset, int[][] lock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                newLock[i + offset][j + offset] = lock[i][j];
            }
        }
    }

    private static void rotateKey(int x, int y, int[][] key, int dir) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                if (dir == 0) {
                    newLock[x + i][y + j] += key[i][j];
                } else if (dir == 1) {
                    newLock[x + i][y + j] += key[key.length - j - 1][i];
                } else if (dir == 2) {
                    newLock[x + i][y + j] += key[key.length - i - 1][key.length - j - 1];
                } else if (dir == 3) {
                    newLock[x + i][y + j] += key[j][key.length - i - 1];
                }
            }
        }
    }

    private static boolean checkPlace(int index, int[][] lock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[i].length; j++) {
                if (newLock[index + i][index + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
