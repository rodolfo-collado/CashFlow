package com.rodolfo.cashflow.domain.contracts.repositories;

import com.rodolfo.cashflow.domain.models.Credenciales;

public interface ICredencialesRepository {

    Long insertar(Credenciales credenciales);

    void actualizar(Credenciales credenciales);

    void borrarPorUsuarioId(Long usuarioId);

    Credenciales buscarPorUsuarioId(Long usuarioId);

    Credenciales buscarPorUsername(String username);

    void cambiarUsername(Long usuarioId, String username);

    void cambiarPassword(Long usuarioId, String password);

    void cambiarPin(Long usuarioId, String pin);


}
