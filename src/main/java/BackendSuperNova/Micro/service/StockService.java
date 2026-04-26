package BackendSuperNova.Micro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import BackendSuperNova.Micro.model.Stock;
import BackendSuperNova.Micro.repository.StockRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @SuppressWarnings("null")
    public Stock findById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    public void delete(Long id) {
        stockRepository.deleteById(id);
    }
}