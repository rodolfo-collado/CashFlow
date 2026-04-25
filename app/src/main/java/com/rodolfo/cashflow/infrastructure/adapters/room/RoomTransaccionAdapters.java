package com.rodolfo.cashflow.infrastructure.adapters.room;

import com.rodolfo.cashflow.domain.contracts.repositories.ItransacionRepository;
import com.rodolfo.cashflow.domain.models.Transaccion;
import com.rodolfo.cashflow.infrastructure.adapters.dao.TransaccionDao;

import java.util.List;

public class RoomTransaccionAdapters implements ItransacionRepository {
    private final TransaccionDao dao;

    public RoomTransaccionAdapters(TransaccionDao dao) {
        this.dao = dao;
    }

    @Override
    public void guardar(Transaccion transaccion) {
        dao.insertar(transaccion);
    }

    @Override
    public List<Transaccion> obtenerTodas() {
        return dao.obtenerTodos();
    }

    @Override
    public List<Transaccion> obtenerGastos() {
        return dao.obtenerSoloGastos();
    }

    @Override
    public List<Transaccion> obtenerTransferencias() {
        return dao.obtenerSoloTransferencias();
    }

    @Override
    public void borrar(int id) {
        dao.eliminarPorId(id);
    }
}
