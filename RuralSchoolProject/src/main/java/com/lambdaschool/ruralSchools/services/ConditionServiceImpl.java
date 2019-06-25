package com.lambdaschool.ruralSchools.services;

import com.lambdaschool.ruralSchools.models.Condition;
import com.lambdaschool.ruralSchools.repository.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "conditionService")
public class ConditionServiceImpl implements ConditionService
{
    @Autowired
    private ConditionRepository conditionRepository;

    @Override
    public List<Condition> findAll(Pageable pageable) {
        List<Condition> list = new ArrayList<>();
        conditionRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Condition findConditionById(long id) throws EntityNotFoundException
    {
        return conditionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }
}
