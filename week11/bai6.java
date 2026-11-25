import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<Double> runningMedian(List<Integer> a) {
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> highers = new PriorityQueue<>();

        List<Double> result = new ArrayList<>();

        for (int num : a) {
            if (lowers.isEmpty() || num <= lowers.peek()) {
                lowers.add(num);
            } else {
                highers.add(num);
            }

            if (lowers.size() > highers.size() + 1) {
                highers.add(lowers.poll());
            } else if (highers.size() > lowers.size() + 1) {
                lowers.add(highers.poll());
            }

            if (lowers.size() == highers.size()) {
                result.add(((double) lowers.peek() + highers.peek()) / 2.0);
            } else if (lowers.size() > highers.size()) {
                result.add((double) lowers.peek());
            } else {
                result.add((double) highers.peek());
            }
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
