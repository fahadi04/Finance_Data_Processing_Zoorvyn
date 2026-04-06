package fahad.financedashboard.service;

import fahad.financedashboard.entity.FinancialRecord;
import fahad.financedashboard.repository.FinancialRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final FinancialRecordRepository repository;

    public DashboardService(FinancialRecordRepository repository) {
        this.repository = repository;
    }

    public double getTotalIncome() {

        return repository.findByType("income")
                .stream()
                .mapToDouble(
                        FinancialRecord::getAmount
                )
                .sum();
    }

    public double getTotalExpense() {

        return repository.findByType("expense")
                .stream()
                .mapToDouble(
                        FinancialRecord::getAmount
                )
                .sum();
    }

    public double getNetBalance() {

        return getTotalIncome()
                - getTotalExpense();
    }
}
