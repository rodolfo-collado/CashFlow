package com.rodolfo.cashflow.infrastructure.di;

import android.content.Context;

import androidx.room.Room;

import com.rodolfo.cashflow.application.AuthService;
import com.rodolfo.cashflow.application.FlujoDineroService;
import com.rodolfo.cashflow.application.GestionCredencialesService;
import com.rodolfo.cashflow.application.GestionUsuarioService;
import com.rodolfo.cashflow.domain.contracts.services.IAuthService;
import com.rodolfo.cashflow.domain.contracts.repositories.ICredencialesRepository;
import com.rodolfo.cashflow.domain.contracts.repositories.ITransaccionRepository;
import com.rodolfo.cashflow.domain.contracts.repositories.IUsuarioRepository;
import com.rodolfo.cashflow.domain.contracts.services.ICredencialesService;
import com.rodolfo.cashflow.domain.contracts.services.ISaldoService;
import com.rodolfo.cashflow.domain.contracts.services.IUsuarioService;
import com.rodolfo.cashflow.infrastructure.adapters.dao.CredencialesDao;
import com.rodolfo.cashflow.infrastructure.adapters.dao.TransaccionDao;
import com.rodolfo.cashflow.infrastructure.adapters.dao.UsuarioDao;
import com.rodolfo.cashflow.infrastructure.adapters.room.AppDataBase;
import com.rodolfo.cashflow.infrastructure.adapters.room.RoomCredencialesAdapters;
import com.rodolfo.cashflow.infrastructure.adapters.room.RoomTransaccionAdapters;
import com.rodolfo.cashflow.infrastructure.adapters.room.RoomUsuarioAdapters;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

import javax.inject.Singleton;

@Module
@InstallIn(SingletonComponent.class)
public abstract class AppModule {

    @Binds
    @Singleton
    abstract ICredencialesRepository bindCredencialesRepository(RoomCredencialesAdapters impl);

    @Binds
    @Singleton
    abstract IUsuarioRepository bindUsuarioRepository(RoomUsuarioAdapters impl);

    @Binds
    @Singleton
    abstract ITransaccionRepository bindTransaccionRepository(RoomTransaccionAdapters impl);

    @Binds
    @Singleton
    abstract IAuthService bindAuthService(AuthService impl);

    @Binds
    @Singleton
    abstract ICredencialesService bindCredencialesService(GestionCredencialesService impl);

    @Binds
    @Singleton
    abstract IUsuarioService bindUsuarioService(GestionUsuarioService impl);

    @Binds
    @Singleton
    abstract ISaldoService bindSaldoService(FlujoDineroService impl);

    @Provides
    @Singleton
    static AppDataBase provideDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(
                context,
                AppDataBase.class,
                "cashflow.db"
        ).build();
    }

    @Provides
    static UsuarioDao provideUsuarioDao(AppDataBase database) {
        return database.usuarioDao();
    }

    @Provides
    static CredencialesDao provideCredencialesDao(AppDataBase database) {
        return database.credencialesDao();
    }

    @Provides
    static TransaccionDao provideTransaccionDao(AppDataBase database) {
        return database.transaccionDao();
    }
}
