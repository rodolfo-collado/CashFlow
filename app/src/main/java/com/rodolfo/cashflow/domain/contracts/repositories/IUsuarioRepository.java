package com.rodolfo.cashflow.domain.contracts.repositories;

import com.rodolfo.cashflow.domain.models.Usuario;

public interface IUsuarioRepository {

    Usuario buscarUsuario(Integer id);

    void actualizar(Usuario usuario);

    void insertar(Usuario usuario);

    void borrar(Integer id);
}
