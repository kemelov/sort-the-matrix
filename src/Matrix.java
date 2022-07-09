import java.lang.reflect.Array;
import java.nio.channels.ScatteringByteChannel;
import java.util.*;

import static java.util.Collections.*;

public class Matrix {
    public int[][] m = new int[5][5];
    public Scanner Enter = new Scanner(System.in);
    public int scanner;

    Matrix() {
        m[0][0] = 21; m[0][1] = 8; m[0][2] = 17; m[0][3] = 14; m[0][4] = 4;
        m[1][0] = 11; m[1][1] = 1; m[1][2] = 20; m[1][3] = 3; m[1][4] = 23;
        m[2][0] = 16; m[2][1] = 19; m[2][2] = 2; m[2][3] = 7; m[2][4] = 10;
        m[3][0] = 25; m[3][1] = 12; m[3][2] = 18; m[3][3] = 9; m[3][4] = 15;
        m[4][0] = 13; m[4][1] = 5; m[4][2] = 24; m[4][3] = 22; m[4][4] = 6;

        for (int[] i : m) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        Source();
    }

    public void sortByRow() {
        for (int i[] : m) {
            Arrays.sort(i);
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        Source();
    }

    public void sortByCol(int[][] m) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                arrayList.add(m[j][i]);
            }
            Collections.sort(arrayList);
            for (int j = 0; j < m.length; j++) {
                m[j][i] = arrayList.get(j);
            }
            arrayList.clear();
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        Source();
    }

    public void sortByDiagonal(int[][] m) {
        int y = m.length, x = m[0].length - 1;
        int[] diag = new int[y];
        for (int i = 2 - y; i < x; i++) {
            int k = 0;
            for (int j = 0; j < y; j++)
                if (i + j >= 0 && i + j <= x)
                    diag[k++] = m[j][i + j];
            Arrays.sort(diag, 0, k);
            k = 0;
            for (int j = 0; j < y; j++) {
                if (i + j >= 0 && i + j <= x) {
                    m[j][i + j] = diag[k++];
                }
            }

        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }
        Source();
    }

    public void sortChosen() {
        System.out.println("1 - Строка" + "\n" + "2 - Столбец");
        scanner = Enter.nextInt();
        switch (scanner) {
            case 1:
                sortChRow();
            case 2:
                sortChCol();
        }
    }


    public void sortChRow() {
        System.out.println("Выберите цифры от 0 до 4. (нажмите 9, чтобы вернуться к основному меню)");
        scanner = Enter.nextInt();
        switch (scanner) {
            case 0, 1, 2, 3, 4:
                Arrays.sort(m[scanner]);
                for (int i[] : m) {
                    for (int j : i) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
                sortChRow();
            case 9: Source();
            default: System.out.println("Ошибка! Выберите цифры от 0 до 4.");
            sortChRow();
        }
    }

    public void sortChCol() {
        System.out.println("Выберите цифры от 0 до 4. (нажмите 9, чтобы вернуться к основному меню)");
        scanner = Enter.nextInt();
        switch (scanner) {
            case 0, 1, 2, 3, 4:
                Arrays.sort(m, Comparator.comparingDouble(o -> o[scanner]));
                for (int i[] : m) {
                    for (int j : i) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
                sortChCol();
            case 9: Source();
            default: System.out.println("Ошибка! Выберите цифры от 0 до 4.");
                sortChRow();
        }
    }



    public void Source(){
        m[0][0] = 21; m[0][1] = 8; m[0][2] = 17; m[0][3] = 14; m[0][4] = 4;
        m[1][0] = 11; m[1][1] = 1; m[1][2] = 20; m[1][3] = 3; m[1][4] = 23;
        m[2][0] = 16; m[2][1] = 19; m[2][2] = 2; m[2][3] = 7; m[2][4] = 10;
        m[3][0] = 25; m[3][1] = 12; m[3][2] = 18; m[3][3] = 9; m[3][4] = 15;
        m[4][0] = 13; m[4][1] = 5; m[4][2] = 24; m[4][3] = 22; m[4][4] = 6;

        System.out.println("\n"+"В каком порядке хотите отсортировать?"+
                           "\n"+"1 - По линиям"+
                           "\n"+"2 - По столбцам"+
                           "\n"+"3 - По диагонали"+
                           "\n"+"4 - Выбрать строку или столбец"  );
        scanner = Enter.nextInt();
        switch (scanner){
            case 1: sortByRow();
            case 2: sortByCol(m);
            case 3: sortByDiagonal(m);
            case 4: sortChosen();
            default:
                System.out.println("Ошибка! Напишите номер пункта в консоль");
                Source();
                break;
        }
    }
}


