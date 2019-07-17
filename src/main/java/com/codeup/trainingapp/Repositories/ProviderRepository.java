package com.codeup.trainingapp.Repositories;

import com.codeup.trainingapp.models.Needs.Provider;
import org.springframework.data.repository.CrudRepository;

public interface ProviderRepository extends CrudRepository<Provider, Long> {
    Provider findByCoordinator_Id(Long id);

}
