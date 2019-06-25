package com.lambdaschool.ruralSchools.services;

import com.lambdaschool.ruralSchools.models.Condition;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ConditionService
{
    List<Condition> findAll(Pageable pageable);

    Condition findConditionById(long id);
}
