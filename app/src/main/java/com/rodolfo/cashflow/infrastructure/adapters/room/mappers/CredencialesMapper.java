package com.rodolfo.cashflow.infrastructure.adapters.room.mappers;

import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.CredencialesEntity;

public class CredencialesMapper {

    private CredencialesMapper() {}

    public static CredencialesEntity toEntity(Credenciales domain){
        return new CredencialesEntity(
                domain.getId(),
                domain.getUsuarioId(),
                domain.getUsername(),
                domain.getPassword(),
                domain.getPin()
        );
    }

    public static Credenciales toDomain(CredencialesEntity entity) {
        return new Credenciales(
                entity.getId(),
                entity.getUsuarioId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getPin()
        );
    }
}
