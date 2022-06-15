package by.furnitureDIY.store.dao.repository;

import by.furnitureDIY.store.dao.entity.Material;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer>, JpaSpecificationExecutor<Material> {

    @Override
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"brand", "category", "decor", "format", "thickness", "texture"}
    )
    List<Material> findAll();

    @Override
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"brand", "category", "decor", "format", "thickness", "texture"}
    )
    Material getById(Integer id);
}