package org.example.class07.varargs;

public class VarargsExample {

    public static void main(String[] args) {

        // Um único método aceita qualquer quantidade de argumentos
        System.out.println(SalaryUtils.averageSalary(1_000.0, 3_000.0));
        System.out.println(SalaryUtils.averageSalary(1_000.0, 3_000.0, 5_000.0));
        System.out.println(SalaryUtils.averageSalary(1_000.0, 3_000.0, 5_000.0, 7_000.0));

        // Também aceita zero argumentos (o arranjo fica vazio)
        System.out.println(SalaryUtils.averageSalary());

        // E aceita um arranjo já pronto
        double[] salaries = {2_000.0, 4_000.0, 9_000.0};
        System.out.println(SalaryUtils.averageSalary(salaries));
        System.out.println(SalaryUtils.highestSalary(salaries));

        // Parâmetro normal + varargs
        System.out.println(SalaryUtils.report("Equipe A", 1_000.0, 2_000.0));
        System.out.println(SalaryUtils.report("Equipe B", salaries));

        System.out.println(SalaryUtils.join(", ", "Java", "Streams", "Varargs"));

        // Regras:
        // 1) Só pode haver UM varargs por método.
        // 2) O varargs deve ser o ÚLTIMO parâmetro.
        // 3) Todos os elementos do varargs têm o mesmo tipo.
    }
}
