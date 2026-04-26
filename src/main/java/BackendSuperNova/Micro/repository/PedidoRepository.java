package BackendSuperNova.Micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import BackendSuperNova.Micro.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}