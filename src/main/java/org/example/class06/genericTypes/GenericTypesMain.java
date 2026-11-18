package org.example.class06.genericTypes;
public class GenericTypesMain {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Claude Shannon", 5000.0),
                new Employee("Edsger Dijkstra", 6500.0),
                new Employee("David Huffman", 5800.0)
        };

        Computer[] computers = {
                new Computer("Dell", 16, 4500.0),
                new Computer("Apple", 32, 12000.0)
        };

        // Lambda: implementação compacta da interface funcional Exporter
        Exporter exporter = (content, destination) -> System.out.println(content);

        // O mesmo código genérico gera relatórios de tipos diferentes
        ReportService<Employee> employeeService = new ReportService<>(exporter, new CsvFormatter<>());
        employeeService.createReport(employees, null);

        System.out.println("---");

        ReportService<Computer> computerService = new ReportService<>(exporter, new CsvFormatter<>());
        computerService.createReport(computers, null);

        // Double[] prices = {10.3, 40.3};
        // ReportService<Double> service = ...; // ERRO DE COMPILAÇÃO: Double não é Reportable

        System.out.println("---");

        // Métodos genéricos
        GenericMethods.printAll(new String[]{"Java", "Generics"});
        Integer second = GenericMethods.printFirstReturnSecond("Olá", 10);
        System.out.println("Retorno: " + second);
    }
}
