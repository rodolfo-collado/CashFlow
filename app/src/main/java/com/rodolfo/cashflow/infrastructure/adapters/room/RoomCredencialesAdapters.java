package com.rodolfo.cashflow.infrastructure.adapters.room;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.infrastructure.adapters.dao.CredencialesDao;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.CredencialesEntity;
import com.rodolfo.cashflow.infrastructure.adapters.room.mappers.CredencialesMapper;

@Singleton
public class RoomCredencialesAdapters implements ICredencialesRepository {
    private final CredencialesDao dao;

    @Inject
    public RoomCredencialesAdapters(CredencialesDao dao) {
        this.dao = dao;
    }


    @Override
    public Long insertar(Credenciales credenciales) {
        CredencialesEntity entity = CredencialesMapper.toEntity(credenciales);
        return dao.insertar(entity);
    }

    @Override
    public void actualizar(Credenciales credenciales) {
        CredencialesEntity entity = CredencialesMapper.toEntity(credenciales);
        dao.actualizar(entity);
    }

    @Override
    public void borrarPorUsuarioId(Long usuarioId) {
        dao.borrarPorUsuarioId(usuarioId);
    }

    @Override
    public Credenciales buscarPorUsuarioId(Long usuarioId) {
        CredencialesEntity entity = dao.buscarPorUsuarioId(usuarioId);
        return CredencialesMapper.toDomain(entity);
    }

    @Override
    public Credenciales buscarPorUsername(String username) {
        CredencialesEntity entity = dao.buscarPorUsername(username);
        return CredencialesMapper.toDomain(entity);
    }

    @Override
    public void cambiarUsername(Long usuarioId, String username) {
        dao.cambiarUsername(usuarioId, username);
    }

    @Override
    public void cambiarPassword(Long usuarioId, String password) {
        dao.cambiarPassword(usuarioId, password);
    }

    @Override
    public void cambiarPin(Long usuarioId, String pin) {
        dao.cambiarPin(usuarioId, pin);
    }
}
