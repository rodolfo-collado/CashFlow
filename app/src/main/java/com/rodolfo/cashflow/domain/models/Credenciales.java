package com.rodolfo.cashflow.domain.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(
    tableName = "credenciales",
    foreignKeys = @ForeignKey(
        entity = Usuario.class,
        parentColumns = "id",
        childColumns = "usuario_id",
        onDelete = ForeignKey.CASCADE
    ),
    indices = {@Index(value = {"usuario_id"}, unique = true)}
)
public class Credenciales {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "usuario_id")
    private Long usuarioId;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "token")
    private String token;
}
