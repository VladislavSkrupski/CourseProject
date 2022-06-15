package by.furnitureDIY.store.dao.repository;

import by.furnitureDIY.store.dao.entity.Thickness;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThicknessRepository extends JpaRepository<Thickness, Integer>, JpaSpecificationExecutor<Thickness> {
    @Override
    @EntityGraph(value = "thickness-with-materials-graph", type = EntityGraph.EntityGraphType.FETCH)
    List<Thickness> findAll();

    @Override
    @EntityGraph(value = "thickness-with-materials-graph", type = EntityGraph.EntityGraphType.FETCH)
    Thickness getById(Integer id);
}