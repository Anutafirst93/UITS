package uits.school.domain;

import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface BaseDao<T, I> {

    @Transactional
    T byId(I id);
    @Transactional
    Serializable save(T object);
    @Transactional
    void update(T object);
    @Transactional
    void remove(T object);
    List<T> list();
}
