package org.example.exams.exam02.persistence;

public record DespesaDto(
       int id,
       double valor,
       String nome,
       String cnpj,
       String info,
       String tipo,
       int declaracaoId
) { }
