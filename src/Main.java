import ListAnalyzer.Analyzer;
import baseClasses.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("allah");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int penalty = scanner.nextInt();
        scanner.nextLine();
        Analyzer analyzer = new Analyzer(bank);
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            analyzer.analyze(line);
        }
        analyzer.calculateFines(penalty);
    }
}
