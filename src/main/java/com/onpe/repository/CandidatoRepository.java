package com.onpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.onpe.entity.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{
	
	@Modifying
	@Query (value="UPDATE `candidato` SET `nombre_candidato`=?2, `apellido_candidato`=?3 WHERE `id_candidato`=?1", nativeQuery=true)
	public void update(Integer id, String nombre, String apellido);
	
	public Candidato findById(Integer id);
	
    @Modifying
    @Query(value="DELETE FROM `candidato` WHERE `id_candidato`=?1", nativeQuery=true)
    public void delete(Integer id);
}

// UPDATE `images`.`Photos` SET `PublicId`='qqqq', `Tag`='www' WHERE `Id`='1';
