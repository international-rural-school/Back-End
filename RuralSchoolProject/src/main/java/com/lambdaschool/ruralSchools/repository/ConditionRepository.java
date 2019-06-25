package com.lambdaschool.ruralSchools.repository;

import com.lambdaschool.ruralSchools.models.Condition;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ConditionRepository extends PagingAndSortingRepository<Condition, Long>
{
}
