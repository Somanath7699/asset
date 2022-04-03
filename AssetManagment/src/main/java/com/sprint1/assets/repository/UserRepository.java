package com.sprint1.assets.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint1.assets.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{
	@Query("select u.user_password from User u where user_id=:id")
	public String getPassword(@Param("id") int id);
	@Modifying
	@Query(value="update user_table set role=:role where user_id=:id",nativeQuery=true)
	@Transactional
	public void updateUser(@Param("id") int id,@Param("role")String role);

}
