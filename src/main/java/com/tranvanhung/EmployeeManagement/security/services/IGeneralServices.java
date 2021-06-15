package com.tranvanhung.EmployeeManagement.security.services;

import java.util.Optional;

public interface IGeneralServices<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
