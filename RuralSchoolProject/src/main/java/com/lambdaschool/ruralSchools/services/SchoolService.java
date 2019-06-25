package com.lambdaschool.ruralSchools.services;

import com.lambdaschool.ruralSchools.models.School;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SchoolService
{
    List<School> findAll(Pageable pageable);
}
