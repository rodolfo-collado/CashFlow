package com.rodolfo.cashflow.infrastructure.adapters.room.mappers;

import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.CredencialesEntity;

public class CredencialesMapper {

    private CredencialesMapper() {}

    public static CredencialesEntity toEntity(Credenciales domain){
        CredencialesEntity entity = new CredencialesEntity();
        entity.setId(domain.getId());
        entity.setUsername(domain.getUsername());
        entity.setPassword(domain.getPassword());
        entity.setPin(domain.getPin());
        return entity;
    }

    public static Credenciales toDomain(CredencialesEntity entity){
        return new Credenciales(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getPin()
        );
    }
}
