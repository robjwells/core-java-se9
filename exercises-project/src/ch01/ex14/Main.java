package ch01.ex14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> candidateSquare = new ArrayList<ArrayList<Integer>>();
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            Scanner lineScanner = new Scanner(in.nextLine());
            ArrayList<Integer> lineNumbers = new ArrayList<>();
            while (lineScanner.hasNextInt()) {
                lineNumbers.add(lineScanner.nextInt());
            }
            if (lineNumbers.size() == 0) {
                break;
            }
            candidateSquare.add(lineNumbers);
            lineScanner.close();
        }
        in.close();

        if (candidateSquare.size() == 0) {
            return;
        }

        HashSet<Integer> sums = new HashSet<>();
        int columnSize = candidateSquare.get(0).size();
        // Check row sums match
        candidateSquare.stream()
            .map(list -> list.stream().mapToInt(x -> x).sum())
            .forEach(sums::add);
        // Check column sums match
        IntStream.range(0, columnSize)
            .map(
                index -> candidateSquare.stream().mapToInt(row -> row.get(index)).sum()
            ).forEach(sums::add);
        // Check L-R diagonal
        sums.add(
            IntStream.range(0, columnSize)
                .map(index -> candidateSquare.get(index).get(index))
                .sum()
        );
        // Check R-L diagonal
        sums.add(
            IntStream.range(0, columnSize)
                .map(index -> candidateSquare.get(index).get(columnSize - index - 1))
                .sum()
        );
        System.out.println(sums.size() == 1);
    }
}
