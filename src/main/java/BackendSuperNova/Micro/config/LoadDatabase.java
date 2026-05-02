package BackendSuperNova.Micro.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import BackendSuperNova.Micro.model.Categoria;
import BackendSuperNova.Micro.repository.CategoriaRepository;
import BackendSuperNova.Micro.model.Bodega;
import BackendSuperNova.Micro.repository.BodegaRepository;
import BackendSuperNova.Micro.model.Proveedor;
import BackendSuperNova.Micro.repository.ProveedorRepository;
import BackendSuperNova.Micro.model.Producto;
import BackendSuperNova.Micro.repository.ProductoRepository;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(
            CategoriaRepository categoriaRepo, 
            BodegaRepository bodegaRepo,
            ProveedorRepository proveedorRepo,
            ProductoRepository productoRepo) {
        
        return args -> {
            
            // 1. Cargar Categorías
            Categoria catLacteos = null;
            if (categoriaRepo.count() == 0) {
                System.out.println("Cargando Categorías...");
                catLacteos = categoriaRepo.save(new Categoria(null, "Lácteos"));
                categoriaRepo.save(new Categoria(null, "Bebidas"));
                categoriaRepo.save(new Categoria(null, "Aseo"));
            } else {             
                catLacteos = categoriaRepo.findAll().get(0);
            }

            // 2. Cargar Bodegas
            if (bodegaRepo.count() == 0) {
                System.out.println("Cargando Bodegas...");
                bodegaRepo.save(new Bodega(null, "Bodega Central", "Av. Principal 123"));
                bodegaRepo.save(new Bodega(null, "Bodega Norte", "Av. Los Leones 456"));
            }

            // 3. Cargar Proveedores
            if (proveedorRepo.count() == 0) {
                System.out.println("Cargando Proveedores...");
                Proveedor prov = new Proveedor();
                prov.setRutEmpresa("76.543.210-K");
                prov.setDescripcion("Distribuidora El Sol, bebidas y jugos");
                prov.setTelefono("+56912345678");
                prov.setEmail("ventas@elsol.cl");
                proveedorRepo.save(prov);
            }

            // 4. Cargar Productos (Asociados a una categoría)
            if (productoRepo.count() == 0 && catLacteos != null) {
                System.out.println("Cargando Productos...");
                Producto prod = new Producto();
                prod.setCodigoDeBarras("770123456789");
                prod.setNombre("Leche Entera 1L");
                prod.setDescripcion("Caja de leche entera de vaca");
                prod.setCategoria(catLacteos); // Aquí le pasamos la categoría que creamos arriba
                productoRepo.save(prod);
                
                Producto prod2 = new Producto();
                prod2.setCodigoDeBarras("770987654321");
                prod2.setNombre("Queso Gauda 250g");
                prod2.setDescripcion("Queso laminado ideal para sándwiches");
                prod2.setCategoria(catLacteos);
                productoRepo.save(prod2);
            }

            System.out.println(" Base de datos lista con datos iniciales cargados automáticamente.");
        };
            }
}