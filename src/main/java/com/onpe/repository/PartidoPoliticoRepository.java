package com.onpe.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onpe.entity.PartidoPolitico;

@Repository
@Transactional
public interface PartidoPoliticoRepository extends JpaRepository<PartidoPolitico, Integer>{
	
	@Modifying
	@Query (value="UPDATE `partidopolitico` SET `nombre_partidopolitico`=?2 WHERE `id_partidopolitico`=?1", nativeQuery=true)
	public void update(Integer id, String nombre);
	
	PartidoPolitico findById(int id);
	
    @Modifying
    @Query(value="DELETE FROM `partidopolitico` WHERE `id_partidopolitico`=?1", nativeQuery=true)
    public void delete(Integer id);
}

//Servicio findById(int id);
