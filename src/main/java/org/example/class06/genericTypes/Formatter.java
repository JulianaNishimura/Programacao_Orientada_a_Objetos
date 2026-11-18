package org.example.class06.genericTypes;
// Interface genérica com limite superior: T precisa ser Reportable
public interface Formatter<T extends Reportable> {
    String format(T[] elements);
}
