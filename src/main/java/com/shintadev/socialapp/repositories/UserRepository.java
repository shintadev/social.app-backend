package com.shintadev.socialapp.repositories;

import com.shintadev.socialapp.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE User u SET u.name = ?1 where u.id =?2")
    void updateUserById(String name, String id);
}
