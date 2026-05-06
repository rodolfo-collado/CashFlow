package com.rodolfo.cashflow.domain.contracts.services;

public interface ICredencialesService {

    void cambiarUsername( String password, String username);

    void cambiarPassword(String oldPassword, String newPassword);

    void cambiarPin(String password, String pin);

}
