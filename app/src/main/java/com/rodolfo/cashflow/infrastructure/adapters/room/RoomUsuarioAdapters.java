package com.rodolfo.cashflow.infrastructure.adapters.room;

import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.models.Usuario;
import com.rodolfo.cashflow.infrastructure.adapters.dao.UsuarioDao;

public class RoomUsuarioAdapters implements IUsuarioRepository {
    private final UsuarioDao dao;

    public RoomUsuarioAdapters(UsuarioDao dao) {
        this.dao = dao;
    }

    @Override
    public Long insertar(Usuario usuario) {
        return dao.insertar(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        dao.actualizar(usuario);
    }

    @Override
    public void borrarPorId(Long id) {
        dao.borrarPorId(id);
    }

    @Override
    public void borrar(Usuario usuario) {
        dao.borrar(usuario);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return dao.obtenerUsuarioPorId(id);
    }



}
