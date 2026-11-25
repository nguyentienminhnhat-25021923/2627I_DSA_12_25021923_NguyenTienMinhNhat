class Pair {
    public int min, max;

    Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

public class w10_25021923 {
    public static Pair solve(int[] arr, int l, int r) {
        if (l == r)
            return new Pair(arr[r], arr[r]);
        int mid = (l + r) / 2;
        Pair left = solve(arr, l, mid), right = solve(arr, mid + 1, r);
        left.min = Math.min(left.min, right.min);
        left.max = Math.max(left.max, right.max);
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 3, 2};
        if (arr.length == 0) {
            System.out.println("Mang rong!");
            return;
        }
        Pair res = solve(arr, 0, arr.length - 1);
        System.out.println("Max cua arr: " + res.max);
        System.out.println("Min cua arr: " + res.min);
    }
}