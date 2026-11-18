package org.example.class07.varargs;

import java.util.Arrays;

public final class SalaryUtils {

    private SalaryUtils() {
    }

    // double... salaries  => dentro do método, 'salaries' é um double[]
    public static double averageSalary(double... salaries) {
        return Arrays.stream(salaries).average().orElse(0);
    }

    public static double highestSalary(double... salaries) {
        return Arrays.stream(salaries).max().orElse(0);
    }

    // Parâmetros normais vêm ANTES; o varargs deve ser sempre o ÚLTIMO
    public static String report(String title, double... salaries) {
        return title + ": " + salaries.length + " salários, média = " + averageSalary(salaries);
    }

    public static String join(String separator, String... words) {
        return String.join(separator, words);
    }
}
