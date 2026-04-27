package com.rodolfo.cashflow.domain.contracts.repositories;

import com.rodolfo.cashflow.domain.models.Credenciales;

public interface ICredencialesRepository {

    Long insertar(Credenciales credenciales);

    void actualizar(Credenciales credenciales);

    void borrar(Long id);

    Credenciales buscarPorId(Long id);

    Credenciales buscarPorUsername(String username);

    Credenciales buscarPorToken(String token);

}
