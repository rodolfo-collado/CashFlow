package com.rodolfo.cashflow.infrastructure.adapters.room.mappers;

import com.rodolfo.cashflow.domain.models.Transaccion;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.TransaccionEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TransaccionMapper {

    private TransaccionMapper() {}

    public static TransaccionEntity toEntity(Transaccion domain){
        return new TransaccionEntity(
                domain.getId(),
                domain.getFecha(),
                domain.getMonto(),
                domain.getTipo(),
                domain.getEstado(),
                domain.getIdUsuarioOrigen(),
                domain.getIdUsuarioDestino(),
                domain.getSaldoAnterior(),
                domain.getSaldoPosterior(),
                domain.getLocalExterno(),
                domain.getDescripcion()
        );
    }

    public static Transaccion toDomain(TransaccionEntity entity){
        return new Transaccion(
                entity.getId(),
                entity.getFecha(),
                entity.getMonto(),
                entity.getTipo(),
                entity.getEstado(),
                entity.getIdUsuarioOrigen(),
                entity.getIdUsuarioDestino(),
                entity.getSaldoAnterior(),
                entity.getSaldoPosterior(),
                entity.getLocalExterno(),
                entity.getDescripcion()
        );
    }

    public static List<Transaccion> toDomain(List<TransaccionEntity> entities){
        return entities.stream()
                .map(TransaccionMapper::toDomain)
                .collect(Collectors.toList());
    }

    public static List<TransaccionEntity> toEntity(List<Transaccion> domains){
        return domains.stream()
                .map(TransaccionMapper::toEntity)
                .collect(Collectors.toList());
    }
}
