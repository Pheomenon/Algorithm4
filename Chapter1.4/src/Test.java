/**
 * @Author:Gao
 * @Date:2019-08-18 10:46
 */
class Test {
    static int target = 100;
    static int tries = 0;
    static int i = 0;

    static class StopMsgException extends RuntimeException {
    }

    public static void main(String[] args) {

        try {
            gauss(0);
        } catch (StopMsgException e) {
            System.out.println(tries);
        }
    }

    public static int referee(int num) {
        return Integer.compare(num, target);
    }

    public static void gauss() {
        while (referee(getPow(i)) != 1) {
            if (referee(getPow(i)) == 0) {
                tries++;
                return;
            }
            tries++;
            i++;
        }
        tries++;
        gauss(--i);
    }

    public static void gauss(int base) {
        int x = 0;
        while (referee(getPow(x) + base) != 0) {
            if (referee(getPow(x + 1) + base) == 0) {
                System.out.println(getPow(x) + base);
                throw new StopMsgException();
            }
            if (referee(getPow(x) + base) == -1 && referee(getPow(x + 1) + base) == 1) {
                System.out.println(getPow(x) + base);
                base = getPow(x) + base;
                tries += 2;
                gauss(base);
            }
            System.out.println(getPow(x) + base);
            tries += 3;
            x++;
        }
    }

    public static int getPow(int x) {
        int result = (int) Math.pow(2, x);
        return result;
    }
}