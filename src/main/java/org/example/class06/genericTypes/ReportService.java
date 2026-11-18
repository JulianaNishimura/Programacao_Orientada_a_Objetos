package org.example.class06.genericTypes;
// Classe genérica: funciona para qualquer tipo que seja Reportable
public class ReportService<T extends Reportable> {
    private final Exporter exporter;
    private final Formatter<T> formatter;

    public ReportService(Exporter exporter, Formatter<T> formatter) {
        this.exporter = exporter;
        this.formatter = formatter;
    }

    public void createReport(T[] elements, String destination) {
        String formatted = formatter.format(elements);
        exporter.export(formatted, destination);
    }
}
