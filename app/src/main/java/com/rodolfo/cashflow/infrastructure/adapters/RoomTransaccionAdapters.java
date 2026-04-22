package com.rodolfo.cashflow.infrastructure.adapters;

import com.rodolfo.cashflow.domain.contracts.ItransacionRepository;
import com.rodolfo.cashflow.domain.models.Transaccion;

import java.util.Collections;
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
    public void borrar(int id) {

    }
}
