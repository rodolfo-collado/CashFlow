package com.rodolfo.cashflow.domain.contracts.services;

import com.rodolfo.cashflow.domain.models.Usuario;

public interface IUsuarioService {

    void eliminarUsuario(Integer id);

    void registrarUsuario(Usuario usuario);

    void actualizarUsuario(Usuario usuario);
}
