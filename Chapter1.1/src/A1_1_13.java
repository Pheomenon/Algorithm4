//数组转置

public class A1_1_13 {
    public static void main(String[] args) {
        int[][] array = new int[5][5];
        for(int i = 0;i<array[0].length;i++){
            for(int j=0;j<array[1].length;j++){
                array[i][j]=(int) (Math.random() * 10);
            }
        }
        for(int i = 0;i<array[0].length;i++){
            for(int j=0;j<array[1].length;j++){
                System.out.print(i+", "+j+": ");
                System.out.print("["+array[i][j]+"]"+"   ");
            }
            System.out.println();
        }

        System.out.println();

        for(int z = 0;z<array[0].length;z++){
            for(int o=0;o<array[1].length;o++){
                System.out.print(z+", "+z+": ");
                System.out.printf("[%d]   ", array[o][z]);
            }
            System.out.println();
        }
    }
}
