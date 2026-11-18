package org.example.class06.genericTypes;
// Interface funcional: só um método abstrato, então pode ser usada com lambda
@FunctionalInterface
public interface Exporter {
    void export(String content, String destination);
}
