package com.rodolfo.cashflow.domain.contracts.repositories;

import com.rodolfo.cashflow.domain.models.Usuario;

public interface IUsuarioRepository {

    Long insertar(Usuario usuario);
    void actualizar(Usuario usuario);

    void borrar(Usuario usuario);

    void borrarPorId(Long id);

    Usuario buscarPorId(Long id);

}
