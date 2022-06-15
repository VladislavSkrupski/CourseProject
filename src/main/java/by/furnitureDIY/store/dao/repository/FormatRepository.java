package by.furnitureDIY.store.dao.repository;

import by.furnitureDIY.store.dao.entity.Format;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormatRepository extends JpaRepository<Format, Integer>, JpaSpecificationExecutor<Format> {
    @Override
    @EntityGraph(value = "format-with-materials-graph", type = EntityGraph.EntityGraphType.FETCH)
    List<Format> findAll();

    @Override
    @EntityGraph(value = "format-with-materials-graph", type = EntityGraph.EntityGraphType.FETCH)
    Format getById(Integer id);
}