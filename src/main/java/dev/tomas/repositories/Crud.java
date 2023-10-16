package dev.tomas.repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface Crud<T> {
    CompletableFuture<List<T>> findAll() throws SQLException;
    CompletableFuture<Optional<T>> findById(T id) throws SQLException;
    CompletableFuture<Optional<T>> save(T entity) throws SQLException;
    CompletableFuture<Optional<T>> update(T id) throws SQLException;
    CompletableFuture<Boolean> delete(T id) throws SQLException;
}