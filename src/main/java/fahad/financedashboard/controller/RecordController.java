package fahad.financedashboard.controller;

import fahad.financedashboard.entity.FinancialRecord;
import fahad.financedashboard.service.RecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public FinancialRecord createRecord(
            @RequestBody FinancialRecord record
    ) {
        return recordService.createRecord(record);
    }

    @GetMapping
    public List<FinancialRecord> getRecords() {
        return recordService.getAllRecords();
    }

    @PutMapping("/{id}")
    public FinancialRecord updateRecord(
            @PathVariable Long id,
            @RequestBody FinancialRecord record
    ) {
        return recordService.updateRecord(id, record);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(
            @PathVariable Long id
    ) {
        recordService.deleteRecord(id);
    }
}
