package by.furnitureDIY.store.dao.repository;

import by.furnitureDIY.store.dao.entity.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryOnlyRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {
    @Override
    @EntityGraph(value = "category-graph")
    List<Category> findAll();

    @Override
    @EntityGraph(value = "category-graph")
    Category getById(Integer id);
}