package com.rodolfo.cashflow.infrastructure.adapters.room;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.infrastructure.adapters.dao.CredencialesDao;

@Singleton
public class RoomCredencialesAdapters implements ICredencialesRepository {
    private final CredencialesDao dao;

    @Inject
    public RoomCredencialesAdapters(CredencialesDao dao) {
        this.dao = dao;
    }


    @Override
    public Long insertar(Credenciales credenciales) {
        return dao.insertar(credenciales);
    }

    @Override
    public void actualizar(Credenciales credenciales) {
        dao.actualizar(credenciales);
    }

    @Override
    public void borrarPorUsuarioId(Long usuarioId) {
        dao.borrarPorUsuarioId(usuarioId);
    }

    @Override
    public Credenciales buscarPorUsuarioId(Long usuarioId) {
        return dao.buscarPorUsuarioId(usuarioId);
    }

    @Override
    public Credenciales buscarPorUsername(String username) {
        return dao.buscarPorUsername(username);
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
