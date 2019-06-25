package com.lambdaschool.ruralSchools.repository;

import com.lambdaschool.ruralSchools.models.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long>
{

}
