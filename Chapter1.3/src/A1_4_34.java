/**
 * @Author:Gao
 * @Date:2019-08-18 09:28
 */
/*
热还是冷。你的目标是猜出1到N之间的一个秘密的整数。每次猜完一个整数后，你会知道你的
猜测和这个秘密整数是否相等（如果是则游戏结束）。如果不相等，你会知道你的猜测相比上一次
猜测距离该秘密整数是比较热（接近）还是比较冷（远离）。设计一个算法在~2lgN之内找到这个秘密整数
然后再设计一个算法在~1lgN之内找到这个秘密整数。
 */
public class A1_4_34 {
    static class StopMsgException extends RuntimeException {
    }

    public static void main(String[] args) {

        HotOrCold hotOrCold = new HotOrCold();
        hotOrCold.gauss(0);
        try {
            hotOrCold.gauss(0);
        } catch (StopMsgException e) {
            System.out.println(hotOrCold.tries);
        }
    }
}

class HotOrCold {
    int target = 100;
    int tries = 0;
    int i = 0;

    public int referee(int num) {
        return Integer.compare(num, target);
    }

    public void gauss() {
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

    public void gauss(int base) {
        int x = 0;
        while (referee(getPow(x) + base) != 0) {
            if (referee(getPow(x) + base) == -1 && referee(getPow(x + 1) + base) == 0) {
                throw new A1_4_34.StopMsgException();
            }
            if (referee(getPow(x) + base) == -1 && referee(getPow(x + 1) + base) == 1) {
                base = getPow(x) + base;
                tries++;
                gauss(base);
            }
            tries++;
            x++;
        }
    }

    public int getPow(int x) {
        int result = (int) Math.pow(2, x);
        return result;
    }
}
