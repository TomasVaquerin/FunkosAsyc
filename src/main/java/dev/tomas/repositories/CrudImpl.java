package dev.tomas.repositories;

import dev.tomas.Services.DatabaseManager;
import dev.tomas.models.Funko;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class CrudImpl implements Crud {

    private final DatabaseManager database;

    public CrudImpl(DatabaseManager database) {
        this.database = database;
    }

    @Override
    public CompletableFuture<List> findAll() throws SQLException {
        return CompletableFuture.supplyAsync(() -> {
            List<Funko> list =  new ArrayList<>();
            var sql = "SELECT * FROM funkos";
            try {
                database.connect();

            }catch (SQLException e){

            }
        });
    }

    @Override
    public CompletableFuture<Optional> findById(Object id) throws SQLException {
        return null;
    }

    @Override
    public CompletableFuture<Optional> save(Object entity) throws SQLException {
        return null;
    }

    @Override
    public CompletableFuture<Optional> update(Object id) throws SQLException {
        return null;
    }

    @Override
    public CompletableFuture<Boolean> delete(Object id) throws SQLException {
        return null;
    }
}
