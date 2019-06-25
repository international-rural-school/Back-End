package com.lambdaschool.ruralSchools.services;

import com.lambdaschool.ruralSchools.models.School;
import com.lambdaschool.ruralSchools.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class SchoolServiceImpl implements SchoolService
{
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public List<School> findAll(Pageable pageable) {
        List<School> list = new ArrayList<>();
        schoolRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }
}
