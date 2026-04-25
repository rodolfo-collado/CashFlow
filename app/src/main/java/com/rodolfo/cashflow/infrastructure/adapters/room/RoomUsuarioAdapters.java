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
    public Usuario buscarUsuario(Integer id) {
        return dao.obtenerUsuarioPorId(id);
    }

    @Override
    public void actualizar(Usuario usuario) {
        dao.actualizar(usuario);
    }

    @Override
    public void insertar(Usuario usuario) {
        dao.insertar(usuario);
    }

    @Override
    public void borrar(Integer id) {
        dao.eliminarPorId(id);
    }
}
