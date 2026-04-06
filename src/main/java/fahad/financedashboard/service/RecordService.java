package fahad.financedashboard.service;

import fahad.financedashboard.entity.FinancialRecord;
import fahad.financedashboard.repository.FinancialRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    private final FinancialRecordRepository repository;

    public RecordService(FinancialRecordRepository repository) {
        this.repository = repository;
    }

    public FinancialRecord createRecord(
            FinancialRecord record
    ) {
        return repository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return repository.findAll();
    }

    public FinancialRecord updateRecord(
            Long id,
            FinancialRecord record
    ) {
        FinancialRecord existing = repository
                .findById(id)
                .orElseThrow();

        existing.setAmount(record.getAmount());
        existing.setCategory(record.getCategory());
        existing.setType(record.getType());
        existing.setDate(record.getDate());
        existing.setNotes(record.getNotes());

        return repository.save(existing);
    }

    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
}
