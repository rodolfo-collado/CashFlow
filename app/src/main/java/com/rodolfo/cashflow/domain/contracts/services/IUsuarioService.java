package com.rodolfo.cashflow.domain.contracts.services;

import com.rodolfo.cashflow.domain.models.Usuario;

public interface IUsuarioService {

    void registrar(Usuario usuario);
    void eliminar(Long id);
    void actualizar(Usuario usuario);
}
