package com.rodolfo.cashflow.infrastructure.adapters.room.mappers;

import com.rodolfo.cashflow.domain.models.Cuenta;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.CuentaEntity;

public class CuentaMapper {

    private CuentaMapper() {}

    public static CuentaEntity toEntity(Cuenta domain){
        return new CuentaEntity(
                domain.getId(),
                domain.getUsuarioId(),
                domain.getNumeroCuenta(),
                domain.getMoneda(),
                domain.getSaldoTotal(),
                domain.getTipoCuenta(),
                domain.getEstado(),
                domain.getFechaCreacion(),
                domain.getFechaActualizacion()
        );
    }

    public static Cuenta toDomain(CuentaEntity entity){
        return new Cuenta(
                entity.getId(),
                entity.getUsuarioId(),
                entity.getNumeroCuenta(),
                entity.getMoneda(),
                entity.getSaldoTotal(),
                entity.getTipoCuenta(),
                entity.getEstado(),
                entity.getFechaCreacion(),
                entity.getFechaActualizacion()
        );
    }
}
