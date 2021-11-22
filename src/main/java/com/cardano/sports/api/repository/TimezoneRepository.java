package com.cardano.sports.api.repository;

import com.cardano.sports.api.model.Timezone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimezoneRepository extends JpaRepository<Timezone, Long> {
}
