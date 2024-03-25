package lab.web.server.repository;

import lab.web.server.entities.GrossExtDebt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebtRepository extends JpaRepository<GrossExtDebt, Long> {
    List<GrossExtDebt> findByDate(String date);
}
