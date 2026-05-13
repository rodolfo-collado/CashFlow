package com.rodolfo.cashflow.infrastructure.adapters.room.mappers;

import com.rodolfo.cashflow.domain.models.Usuario;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.UsuarioEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    private UsuarioMapper() {}

    public static UsuarioEntity toEntity(Usuario domain) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setApellido(domain.getApellido());
        entity.setCorreo(domain.getCorreo());
        entity.setTelefono(domain.getTelefono());
        entity.setDireccion(domain.getDireccion());
        entity.setSaldoTotal(domain.getSaldoTotal());
        return entity;
    }

    public static Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getCorreo(),
                entity.getTelefono(),
                entity.getDireccion(),
                entity.getSaldoTotal()
        );
    }

    public static List<Usuario> toDomain(List<UsuarioEntity> entities){
        return entities.stream()
                .map(UsuarioMapper::toDomain)
                .collect(Collectors.toList());
    }

    public static List<UsuarioEntity> toEntity(List<Usuario> domains){
        return domains.stream()
                .map(UsuarioMapper::toEntity)
                .collect(Collectors.toList());
    }
}
