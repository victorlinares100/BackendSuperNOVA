package BackendSuperNova.Micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import BackendSuperNova.Micro.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Producto findByCodigoDeBarras(String codigoDeBarras);
}