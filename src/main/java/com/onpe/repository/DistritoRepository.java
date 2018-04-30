package com.onpe.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onpe.entity.Distrito;

@Repository
@Transactional
public interface DistritoRepository extends JpaRepository<Distrito, Integer> {

	@Modifying
	@Query (value="UPDATE `distrito` SET `nombre_distrito`=?2 WHERE `id_distrito`=?1", nativeQuery=true)
	public void update(Integer id, String nombre);
	
	public Distrito findById(Integer id);
	
    @Modifying
    @Query(value="DELETE FROM `distrito` WHERE `id_distrito`=?1", nativeQuery=true)
    public void delete(Integer id);
    
}
