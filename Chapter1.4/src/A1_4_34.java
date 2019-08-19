/**
 * @Author:Gao
 * @Date:2019-08-18 10:46
 */
class A1_4_34 {
    static int target = 1024;
    static int tries = 0;
    static int i = 0;

    static class StopMsgException extends RuntimeException {
    }

    public static void main(String[] args) {
        try {
            gauss(0);
        } catch (StopMsgException e) {
            System.out.println("tries: " + tries);
        }
    }

    public static int referee(int num) {
        return Integer.compare(num, target);
    }

    public static void gauss(int base) {
        int x = 0;
        int result = -1;
        while (result <= 0) {
            result = referee(getPow(x) + base);
            System.out.println(getPow(x) + base);
            tries++;
            if (result == 0) {
                throw new StopMsgException();
            }
            x++;
        }
        x -= 2;
                System.out.println(getPow(x) + base);
                base = getPow(x) + base;
        tries++;
                gauss(base);
    }

    public static int getPow(int x) {
        int result = (int) Math.pow(2, x);
        return result;
    }
}