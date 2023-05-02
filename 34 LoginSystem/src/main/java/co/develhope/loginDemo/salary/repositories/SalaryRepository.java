package co.develhope.loginDemo.salary.repositories;

import co.develhope.loginDemo.salary.entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long>  {

    Salary findByUserId(Long id);


}
