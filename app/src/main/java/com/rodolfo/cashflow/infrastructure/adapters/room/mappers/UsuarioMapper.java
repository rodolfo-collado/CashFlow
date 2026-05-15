package com.rodolfo.cashflow.infrastructure.adapters.room.mappers;

import com.rodolfo.cashflow.domain.models.Usuario;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.UsuarioEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    private UsuarioMapper() {}

    public static UsuarioEntity toEntity(Usuario domain) {
        return new UsuarioEntity(
                domain.getId(),
                domain.getNombre(),
                domain.getApellido(),
                domain.getFechaNacimiento(),
                domain.getCorreo(),
                domain.getTelefono(),
                domain.getDireccion(),
                domain.getCiudad(),
                domain.getPais(),
                domain.getEstadoUsuario(),
                domain.getFechaCreacion(),
                domain.getFechaActualizacion()
        );
    }

    public static Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getFechaNacimiento(),
                entity.getCorreo(),
                entity.getTelefono(),
                entity.getDireccion(),
                entity.getCiudad(),
                entity.getPais(),
                entity.getEstadoUsuario(),
                entity.getFechaCreacion(),
                entity.getFechaActualizacion()
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
