package com.capstone.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.RegUsers;

public interface RegUsersRepo extends JpaRepository<RegUsers, Integer> {
}
