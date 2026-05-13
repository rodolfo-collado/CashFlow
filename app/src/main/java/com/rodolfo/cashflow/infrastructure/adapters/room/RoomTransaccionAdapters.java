package com.rodolfo.cashflow.infrastructure.adapters.room;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.rodolfo.cashflow.domain.contracts.repositories.ITransaccionRepository;
import com.rodolfo.cashflow.domain.models.Transaccion;
import com.rodolfo.cashflow.infrastructure.adapters.dao.TransaccionDao;
import com.rodolfo.cashflow.infrastructure.adapters.room.entities.TransaccionEntity;
import com.rodolfo.cashflow.infrastructure.adapters.room.mappers.TransaccionMapper;

import java.time.LocalDate;
import java.util.List;

@Singleton
public class RoomTransaccionAdapters implements ITransaccionRepository {
    private final TransaccionDao dao;

    @Inject
    public RoomTransaccionAdapters(TransaccionDao dao) {
        this.dao = dao;
    }

    @Override
    public Long insertar(Transaccion transaccion) {
        TransaccionEntity entity =TransaccionMapper.toEntity(transaccion);
        return dao.insertar(entity);
    }

    @Override
    public void borrarPorId(Long id) {
        dao.eliminarPorId(id);
    }

    @Override
    public void actualizar(Transaccion transaccion) {
        TransaccionEntity entity = TransaccionMapper.toEntity(transaccion);
        dao.actualizar(entity);
    }

    @Override
    public List<Transaccion> obtenerTodas() {
        return TransaccionMapper.toDomain(dao.obtenerTodas());

    }


    @Override
    public List<Transaccion> obtenerGastos() {
        return TransaccionMapper.toDomain(dao.obtenerSoloGastos());
    }

    @Override
    public List<Transaccion> obtenerTransferencias() {
        return TransaccionMapper.toDomain(dao.obtenerSoloTransferencias());
    }

    @Override
    public List<Transaccion> obtenerPorFecha(LocalDate fecha) {
        return TransaccionMapper.toDomain(dao.obtenerPorFecha(fecha));
    }

    @Override
    public List<Transaccion> obtenerRangoFecha(LocalDate inicio, LocalDate fin) {
        return TransaccionMapper.toDomain(dao.obtenerRangoFechas(inicio, fin));
    }


}
