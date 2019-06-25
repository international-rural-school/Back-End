package com.lambdaschool.ruralSchools.repository;

import com.lambdaschool.ruralSchools.models.School;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SchoolRepository extends PagingAndSortingRepository<School, Long>
{
}
