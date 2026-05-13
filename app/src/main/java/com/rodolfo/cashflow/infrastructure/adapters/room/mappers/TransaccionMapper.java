package com.rodolfo.cashflow.infrastructure.adapters.room.mappers;

import com.rodolfo.cashflow.domain.models.Transaccion;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.TransaccionEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TransaccionMapper {

    private TransaccionMapper() {}

    public static TransaccionEntity toEntity(Transaccion domain){
        TransaccionEntity entity = new TransaccionEntity();
        entity.setId(domain.getId());
        entity.setDate(domain.getDate());
        entity.setMonto(domain.getMonto());
        entity.setTipo(domain.getTipo());
        entity.setIdUsuarioOrigen(domain.getIdUsuarioOrigen());
        entity.setIdUsuarioDestino(domain.getIdUsuarioDestino());
        entity.setLocalExterno(domain.getLocalExterno());
        entity.setDescripcion(domain.getDescripcion());
        return entity;
    }

    public static Transaccion toDomain(TransaccionEntity entity){
        return new Transaccion(
                entity.getId(),
                entity.getDate(),
                entity.getMonto(),
                entity.getTipo(),
                entity.getIdUsuarioOrigen(),
                entity.getIdUsuarioDestino(),
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
