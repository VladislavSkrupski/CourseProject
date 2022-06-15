package by.furnitureDIY.store.dao.repository;

import by.furnitureDIY.store.dao.entity.Texture;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextureOnlyRepository extends JpaRepository<Texture, Integer>, JpaSpecificationExecutor<Texture> {
    @Override
    @EntityGraph(value = "texture-graph")
    List<Texture> findAll();

    @Override
    @EntityGraph(value = "texture-graph")
    Texture getById(Integer id);
}