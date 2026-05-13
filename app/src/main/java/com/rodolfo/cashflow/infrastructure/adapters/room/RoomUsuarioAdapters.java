package com.rodolfo.cashflow.infrastructure.adapters.room;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.models.Usuario;
import com.rodolfo.cashflow.infrastructure.adapters.dao.UsuarioDao;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.UsuarioEntity;
import com.rodolfo.cashflow.infrastructure.adapters.room.mappers.UsuarioMapper;

@Singleton
public class RoomUsuarioAdapters implements IUsuarioRepository {
    private final UsuarioDao dao;

    @Inject
    public RoomUsuarioAdapters(UsuarioDao dao) {
        this.dao = dao;
    }

    @Override
    public Long insertar(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        return dao.insertar(entity);
    }

    @Override
    public void actualizar(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        dao.actualizar(entity);
    }

    @Override
    public void borrarPorId(Long id) {
        dao.borrarPorId(id);
    }

    @Override
    public void borrar(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        dao.borrar(entity);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return UsuarioMapper.toDomain(dao.obtenerUsuarioPorId(id));
    }



}
