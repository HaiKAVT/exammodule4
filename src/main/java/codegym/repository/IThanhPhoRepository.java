package codegym.repository;

import codegym.model.ThanhPho;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IThanhPhoRepository extends PagingAndSortingRepository<ThanhPho, Integer> {
}
