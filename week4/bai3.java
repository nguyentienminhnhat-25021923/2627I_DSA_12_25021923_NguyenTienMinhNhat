import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {


    public static void insertionSort1(int n, List<Integer> arr) {
        int target = arr.get(n - 1);
        int i = n - 2;

        while (i >= 0 && arr.get(i) > target) {
            arr.set(i + 1, arr.get(i));
            printList(arr);
            i--;
        }

        arr.set(i + 1, target);
        printList(arr);
    }

    private static void printList(List<Integer> arr) {
        for (int j = 0; j < arr.size(); j++) {
            System.out.print(arr.get(j) + (j == arr.size() - 1 ? "" : " "));
        }
        System.out.println();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}