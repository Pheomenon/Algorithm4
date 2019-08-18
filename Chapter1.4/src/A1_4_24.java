/**
 * @Author:Gao
 * @Date:2019-08-17 15:59
 */
/*
扔鸡蛋。假设你面前有一栋N层的大楼和许多鸡蛋，假设将鸡蛋从F层或者更高的地方扔下
鸡蛋才会摔碎，否则不会。首先，设计一种策略来确定F的值，其中扔~lgN次鸡蛋后摔碎
的鸡蛋数量为~lgN，然后想办法将成本降低到~2lgF
 */
public class A1_4_24 {
    public static void main(String[] args) {
        int n = 100;
        //方便go2调用
        //go1(n,0, n-1);
        EggDrop eggDrop = new EggDrop();
        eggDrop.go2(n);
        System.out.println("Number of the Broken Eggs  is " + eggDrop.numsOfEggBroken);
        System.out.println("Number of trying is " + eggDrop.numsOfTry);
    }
}

class EggDrop {
    //供预测的提前设定的解，也可以直接random一个，为方便测试直接给定。
    public static int T = 99;
    //尝试了几次
    static int numsOfTry = 0;
    //摔碎了多少个鸡蛋
    static int numsOfEggBroken = 0;

    //扔鸡蛋抽象为一个方法，扔的时候更新尝试次数和鸡蛋碎了没有的次数，同时打印尝试的过程和结果
    public static boolean drop(int i) {
        numsOfTry++;
        if (i < T) {
            System.out.println("from " + i + " no");
            return false;
        } else {
            System.out.println("from " + i + " yes");
            numsOfEggBroken++;
            return true;
        }
    }
    //以下为version0-4的实现，前面注释给出的两个数字分别为
    //（摔坏的鸡蛋数的期望，尝试次数的期望）

    //1egg;T
    public static void go0(int n) {
        for (int i = 0; i < n; i++) {
            boolean tmp = drop(i);
            if (tmp == true) {
                System.out.println("T is " + i);
                break;
            }
        }
    }

    //lg(n)egg;lg(n)
    //为方便go2调用，把其改为了带上下界的二分的方法。
    public static void go1(int n, int start, int end) {
        boolean tmp = drop((start + end) / 2);
        ;
        while (start < end) {
            if (tmp == false) {
                start = (start + end) / 2 + 1;
                tmp = drop((start + end) / 2);
            } else {
                end = (start + end) / 2 - 1;
                tmp = drop((start + end) / 2);
            }
        }
        if (tmp == false) {
            System.out.println("T is " + ((start + end) / 2 + 1));
        } else {
            System.out.println("T is " + (start + end) / 2);
        }
    }

    //lg(T)egg;2lg(T)
    public static void go2(int n) {
        int k = -1;
        int start = 0;
        int end = n - 1;
        for (int i = 0; i < Math.sqrt(n) - 1; i++) {
            int t = (int) Math.pow(2, (double) i);
            boolean tmp = drop(t);
            if (tmp == true) {
                k = (int) Math.pow(2, (double) i);
                start = (int) Math.pow(2, (double) i - 1);
                end = (int) Math.pow(2, (double) i);
                break;
            }

        }
        go1(n, start, end);
    }

    //2egg;2根号n
    public static void go3(int n) {
        int l = (int) Math.sqrt(n);
        int k = -1;
        for (int i = 0; i * l < n; i++) {
            boolean tmp = drop(i * l);
            if (tmp == true) {
                k = i;
                break;
            }
        }
        for (int i = (k - 1) * l + 1; i < k * l; i++) {
            boolean tmp = drop(i);
            if (tmp == true) {
                System.out.println("\nT is " + i);
                break;
            }
        }
    }

    //2egg ;3根号T
    public static void go4(int n) {
        int k = -1;
        for (int i = 1; Math.pow(i, 2) < n; i++) {
            boolean tmp = drop((int) Math.pow(i, 2));
            if (tmp == true) {
                k = i;
                break;
            }
        }
        for (int i = (int) Math.pow(k - 1, 2) + 1; i < Math.pow(k, 2); i++) {
            boolean tmp = drop(i);
            if (tmp == true) {
                System.out.println("\nT is " + i);
                break;
            }
        }
    }
}
