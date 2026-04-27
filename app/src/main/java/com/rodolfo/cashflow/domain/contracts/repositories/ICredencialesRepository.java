package com.rodolfo.cashflow.domain.contracts.repositories;

import com.rodolfo.cashflow.domain.models.Credenciales;

public interface ICredencialesRepository {

    void insertar(Credenciales credenciales);

    void actualizar(Credenciales credenciales);

    void borrar(Integer id);

    Credenciales buscarPorId(Integer id);

    Credenciales buscarPorUsername(String username);

    Credenciales buscarPorToken(String token);

}
