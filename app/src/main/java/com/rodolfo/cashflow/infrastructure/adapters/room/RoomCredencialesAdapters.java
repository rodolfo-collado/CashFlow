package com.rodolfo.cashflow.infrastructure.adapters.room;

import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.models.Credenciales;
import com.rodolfo.cashflow.infrastructure.adapters.dao.CredencialesDao;

public class RoomCredencialesAdapters implements ICredencialesRepository {
    private final CredencialesDao dao;


    public RoomCredencialesAdapters(CredencialesDao dao) {
        this.dao = dao;
    }

    @Override
    public Credenciales buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    @Override
    public Credenciales buscarPorUsername(String username) {
        return dao.buscarPorUsername(username);
    }

    @Override
    public Credenciales buscarPorToken(String token) {
        return dao.buscarPorToken(token);
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
    public void borrar(Long id) {
        dao.borrar(id);
    }
}
