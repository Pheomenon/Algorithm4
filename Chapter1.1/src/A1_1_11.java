public class A1_1_11 {
    public static void main(String[] args) {
        boolean[][] array = new boolean[2][2];
        System.out.println("  1"+'2');
        for(int i=0;i<2;i++){
            System.out.print((i+1));
            for(int j=0;j<2;j++){
                if(array[i][j]==false)
                    System.out.print('*');
            }
            System.out.println(' ');
        }
    }
}
