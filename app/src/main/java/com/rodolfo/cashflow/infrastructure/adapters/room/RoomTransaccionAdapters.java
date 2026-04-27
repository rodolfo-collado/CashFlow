package com.rodolfo.cashflow.infrastructure.adapters.room;

import com.rodolfo.cashflow.domain.contracts.repositories.ITransaccionRepository;
import com.rodolfo.cashflow.domain.models.Transaccion;
import com.rodolfo.cashflow.infrastructure.adapters.dao.TransaccionDao;

import java.time.LocalDate;
import java.util.List;

public class RoomTransaccionAdapters implements ITransaccionRepository {
    private final TransaccionDao dao;

    public RoomTransaccionAdapters(TransaccionDao dao) {
        this.dao = dao;
    }

    @Override
    public void insertar(Transaccion transaccion) {
        dao.insertar(transaccion);
    }

    @Override
    public void borrar(int id) {
        dao.eliminarPorId(id);
    }

    @Override
    public void actualizar(Transaccion transaccion) {
        dao.actualizar(transaccion);
    }

    @Override
    public List<Transaccion> obtenerTodas() {
        return dao.obtenerTodas();
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
    public List<Transaccion> obtenerPorFecha(LocalDate fecha) {
        return dao.obtenerPorFecha(fecha);
    }

    @Override
    public List<Transaccion> obtenerRangoFecha(LocalDate inicio, LocalDate fin) {
        return dao.obtenerRangoFechas(inicio, fin);
    }


}
