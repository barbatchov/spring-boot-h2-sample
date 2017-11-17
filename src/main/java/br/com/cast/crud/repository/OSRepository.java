package br.com.cast.crud.repository;

import br.com.cast.crud.domain.OS;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OSRepository extends CrudRepository<OS, Integer> {
    OS findById(Integer id);
    OS removeById(Integer id);
}
