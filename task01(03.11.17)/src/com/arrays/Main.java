package com.arrays;

import java.util.Arrays;
import java.util.Random;
/*
Сортировка последовательности
1. Упорядочить одномерный масиве вначале отрицательные повозрастанию
   затем положительные по убыванию.
2. В одномерном массиве сначала положительные потом отрицательные за О .

Дана целочисленная прямоугольная матрица.
3. Упорядочить столбцы по убыванию среднего значения.
4. Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.
5. Дана квадратная матрица A порядка M (M — нечетное число). Начи-
ная с элемента A1,1 и перемещаясь по часовой стрелке, вывести все ее эле-
менты по спирали: первая строка, последний столбец, последняя строка в
обратном  порядке,  первый  столбец  в  обратном  порядке,  оставшиеся  эле-
менты второй строки и т. д.; последним выводится центральный элемент
матрицы.
 */
interface hasAverage{
    double calculateAverage();
    double getAverage();
}
interface hasSeries{
    int getLongestSerieSize();
}
class Row implements hasAverage, hasSeries{
    int sum=0;
    int[] data={};
    int length=0;
    public void setData(int[] data) {
        this.data = data;
    }

    Row(int length){
        this.length = length;
        data= new int[length];
    }

    Row(int[] arr){
        this.length=arr.length;
        this.data=arr;
    }
    @Override
    public double calculateAverage() {
        int sum =0;
        for(int i=0;i<length;i++){
            sum+=data[i];
        }
        return 1.0*sum/length;
    }

    @Override
    public double getAverage() {
        return calculateAverage();
    }
    @Override
    public String toString(){
        return Arrays.toString(data);
    }

    @Override
    public int getLongestSerieSize() {
        int longest=0,i=0;
        while(i<length){
            int key = data[i],size=0;
            while(i<length&&data[i]==key){
                size++;
                i++;
            }
            longest=Math.max(longest,size);
        }
        return longest;
    }

}
class Matrix{
    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    private
    Row[] rows;
    private int length,height;
    Matrix(int length, int height){
        this.length=length;
        this.height=height;
        for(int i=0;i<height;i++){
            rows[i] = new Row(length);
        }
    }
    public Row getRow(int i){
        return rows[i];
    }
    public void setRow(int i, Row row){
        rows[i]=row;
    }
    public Matrix(int[][] arr, boolean isRow){
        if(isRow) {
            rows = new Row[arr.length];
            this.length = arr[0].length;
            this.height = arr.length;
            for (int i = 0; i < height; i++) {
                this.rows[i] = new Row(arr[i]);
            }
        }
        else{
            int[][] transArr = new int[arr[0].length][arr.length];
            for(int i=0;i<arr[0].length;i++){
                for(int j=0;j<arr.length;j++){
                    transArr[i][j]=arr[j][i];
                }
            }
            this.length = transArr[0].length;
            this.height = transArr.length;
            rows = new Row[height];
            for (int i = 0; i < height; i++) {
                this.rows[i] = new Row(transArr[i]);
            }
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[\n\n  ");
        for(int i=0;i<height;i++){
            sb.append(rows[i].toString());
            sb.append(",\n  ");
        }
        sb.append("\n]");
        return new String(sb);
    }
}

public class Main {
    private static int[] solveFirstTask(int[] array){
        int p=0;
        for(int i=0;i<array.length;i++){
            if(array[i]<0){
                int t = array[i];
                array[i]=array[p];
                array[p++]=t;
            }
        }
        for(int i=0;i<p;i++){
            for(int j=0;j<p-1;j++){
                if(array[j]<array[j+1]){
                    int t = array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
        for(int i=p;i<array.length;i++){
            for(int j=p;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    int t = array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
        return array;
    }
    private static final double EPS=0.001;
    private static int[] solveSecondTask(int[] array){
        int j=0;
        for(int i=0;i<array.length;i++){
            if(array[i]>0){
                int t = array[i];
                array[i]=array[j];
                array[j++]=t;
            }
        }
        return array;
    }
    private static Matrix solveThirdTask(int[][] arr){
        Matrix arrMatrix = new Matrix(arr,false);
        for(int i=0;i<arrMatrix.getHeight();i++){
            for(int j=0;j<arrMatrix.getHeight()-1;j++){
                if(arrMatrix.getRow(j).getAverage()-arrMatrix.getRow(j+1).getAverage()<EPS){
                    Row t = arrMatrix.getRow(j);
                    arrMatrix.setRow(j,arrMatrix.getRow(j+1));
                    arrMatrix.setRow(j+1,t);
                }
            }
        }
        return arrMatrix;
    }
    private static Matrix solveFourthTask(int[][] arr){
        Matrix arrMatrix = new Matrix(arr,true);
        for(int i=0;i<arrMatrix.getHeight();i++){
            for(int j=0;j<arrMatrix.getHeight()-1;j++){
                if(arrMatrix.getRow(j).getLongestSerieSize()>arrMatrix.getRow(j+1).getLongestSerieSize()){
                    Row t = arrMatrix.getRow(j);
                    arrMatrix.setRow(j,arrMatrix.getRow(j+1));
                    arrMatrix.setRow(j+1,t);
                }
            }
        }
        return arrMatrix;
    }
    private static int[][] solveFifthTask(){
        int[][] res = new int[5][5];
        int len=1,i;
        int x1=0,x2=res.length-1,y1=0,y2=res[0].length-1;
        while(len<res.length*res[0].length)
        {
            for(i=x1;i<=x2;i++)
            {
                res[i][y1]=len;
                len++;
            }
            len--;
            for( i=y1;i<=y2;i++)
            {
                res[x2][i]=len;
                len++;
            }
            len--;
            for( i=x2;i>=x1;i--)
            {
                res[i][y2]=len;
                len++;
            }
            len--;
            for(i=y2;i>y1;i--)
            {
                res[x1][i]=len;
                len++;
            }
            x1++;
            y1++;
            x2--;
            y2--;
        }
        if(res[x1][y1]==0)res[x1][y1]=res.length*res[0].length;
        return res;
    }
    public static void main(String[] args) {
        Random random = new Random(42);
        int[] arr = {3,6,-1,0,18,3,5,-5};
        System.out.println(Arrays.toString(solveFirstTask(arr)));
        System.out.println(Arrays.toString(solveSecondTask(arr)));
        int[][] arr2D = new int[5][4];
        for(int i=0;i<arr2D.length;i++){
            for(int j=0;j<arr2D[i].length;j++){
                arr2D[i][j]= random.nextInt()%10;
            }
        }
        System.out.println(solveThirdTask(arr2D));
        for(int i=0;i<arr2D.length;i++){
            for(int j=0;j<arr2D[i].length;j++){
                arr2D[i][j]= Math.abs(random.nextInt()%2);
            }
        }

        System.out.println(solveFourthTask(arr2D));
        int[][] ans = solveFifthTask();
        Matrix m = new Matrix(ans,false);
        System.out.println(m);
    }
}
