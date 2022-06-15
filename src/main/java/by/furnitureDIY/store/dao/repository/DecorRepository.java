package by.furnitureDIY.store.dao.repository;

import by.furnitureDIY.store.dao.entity.Decor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecorRepository extends JpaRepository<Decor, Integer>, JpaSpecificationExecutor<Decor> {
    @Override
    @EntityGraph(value = "decor-with-materials-graph", type = EntityGraph.EntityGraphType.FETCH)
    List<Decor> findAll();

    @Override
    @EntityGraph(value = "decor-with-materials-graph", type = EntityGraph.EntityGraphType.FETCH)
    Decor getById(Integer id);

}