package by.furnitureDIY.store.dao.repository;

import by.furnitureDIY.store.dao.entity.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {
    @Override
    @EntityGraph(value = "category-with-materials-graph", type = EntityGraph.EntityGraphType.FETCH)
    List<Category> findAll();

    @Override
    @EntityGraph(value = "category-with-materials-graph", type = EntityGraph.EntityGraphType.FETCH)
    Category getById(Integer id);
}