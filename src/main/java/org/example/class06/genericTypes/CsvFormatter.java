package org.example.class06.genericTypes;
import java.util.StringJoiner;

public class CsvFormatter<T extends Reportable> implements Formatter<T> {

    @Override
    public String format(T[] elements) {
        StringJoiner joiner = new StringJoiner("\n");

        for (T element : elements) {
            // Não precisa de cast: o limite garante que T é Reportable
            joiner.add(String.join(",", element.reportContent()));
        }
        return joiner.toString();
    }
}
