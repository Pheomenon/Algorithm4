/**
 * @Author:Gao
 * @Date:2019-08-18 10:46
 */
/*
冷还是热。你的目标是猜出1到N之间的一个秘密的整数。每次猜完一个整数后，
你会知道你的猜测和这个秘密整数是否相等（如果是则游戏结束）。如果不相等，你会知道你的
猜测相比上一次猜测距离该秘密整数是比较热（接近）还是比较冷）远离，设计一个算法在~1lgN
之内找到这个秘密整数
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