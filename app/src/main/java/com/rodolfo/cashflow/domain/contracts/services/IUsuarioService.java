package com.rodolfo.cashflow.domain.contracts.services;

import com.rodolfo.cashflow.domain.models.Usuario;

public interface IUsuarioService {

    void eliminar(Integer id);

    void registrar(Usuario usuario);

    void actualizar(Usuario usuario);
}
