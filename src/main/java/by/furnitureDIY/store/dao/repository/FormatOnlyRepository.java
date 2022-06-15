package by.furnitureDIY.store.dao.repository;

import by.furnitureDIY.store.dao.entity.Format;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormatOnlyRepository extends JpaRepository<Format, Integer>, JpaSpecificationExecutor<Format> {
    @Override
    @EntityGraph(value = "format-graph")
    List<Format> findAll();

    @Override
    @EntityGraph(value = "format-graph")
    Format getById(Integer id);
}