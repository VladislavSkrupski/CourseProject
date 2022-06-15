package by.furnitureDIY.store.dao.repository;

import by.furnitureDIY.store.dao.entity.Thickness;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThicknessOnlyRepository extends JpaRepository<Thickness, Integer>, JpaSpecificationExecutor<Thickness> {
    @Override
    @EntityGraph(value = "thickness-graph")
    List<Thickness> findAll();

    @Override
    @EntityGraph(value = "thickness-graph")
    Thickness getById(Integer id);
}