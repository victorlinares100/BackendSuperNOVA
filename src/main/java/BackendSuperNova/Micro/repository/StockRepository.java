package BackendSuperNova.Micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import BackendSuperNova.Micro.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}