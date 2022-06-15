package by.furnitureDIY.store.dao.repository;

import by.furnitureDIY.store.dao.entity.Brand;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand> {

    @Override
    @EntityGraph(value = "brand-with-materials-graph", type = EntityGraph.EntityGraphType.FETCH)
    List<Brand> findAll();

    @Override
    @EntityGraph(value = "brand-with-materials-graph", type = EntityGraph.EntityGraphType.FETCH)
    Brand getById(Integer id);

    @EntityGraph(value = "brand-with-materials-graph", type = EntityGraph.EntityGraphType.FETCH)
    Brand getByBrand(String brand);

}
