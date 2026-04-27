package com.rodolfo.cashflow.domain.contracts.repositories;

import com.rodolfo.cashflow.domain.models.Usuario;

public interface IUsuarioRepository {

    void insertar(Usuario usuario);
    void actualizar(Usuario usuario);

    void borrar(Usuario usuario);

    void borrarPorId(Integer id);

    Usuario buscarUsuario(Integer id);

}
