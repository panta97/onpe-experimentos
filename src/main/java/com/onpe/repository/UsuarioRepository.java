package com.onpe.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onpe.entity.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	 
	@Modifying
	@Query (value="UPDATE `usuario` SET `nombre_usuario`=?2, `apellido_usuario`=?3 WHERE `id_usuario`=?1", nativeQuery=true)
	public void update(Integer id, String nombre, String apellido);
	
	public Usuario findById(Integer id);

}

//UPDATE `images`.`Photos` SET `PublicId`='sad', `Tag`='asd' WHERE `Id`='1';
