package ar.com.dinamicaonline.idicse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.com.dinamicaonline.idicse.models.Entidad;

@Repository
public interface ParameterRepository extends JpaRepository<Entidad, Integer> {

    @Query(value = "SELECT parameterValue FROM api_Parameters WHERE id = :id", nativeQuery = true)
    public String findById(@Param("id") int id);

    @Query(value = "SELECT parameterValue FROM api_Parameters WHERE parameterName = :parameterName", nativeQuery = true)
    public String findByParameterName(@Param("parameterName") String parameterName);
}
