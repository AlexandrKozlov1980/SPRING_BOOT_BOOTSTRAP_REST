package com.javaMentor.SpringBoot.Security.repositories;

import com.javaMentor.SpringBoot.Security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select b from User b where b.name = :name")
    User findByName(@Param("name") String name);

    @Query("select b from User b where b.eMail = :eMail")
    User findByEMail(@Param("eMail") String eMail);
}
