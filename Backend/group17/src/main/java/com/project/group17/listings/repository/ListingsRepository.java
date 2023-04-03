package com.project.group17.listings.repository;
import com.project.group17.listings.entity.ListingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.group17.listings.entity.ListingsEntity;
@Repository
public interface ListingsRepository extends JpaRepository<ListingsEntity, Long>
{
}
