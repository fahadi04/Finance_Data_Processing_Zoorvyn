package fahad.financedashboard.controller;

import fahad.financedashboard.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/summary")
    public Map<String, Double> summary() {

        Map<String, Double> data = new HashMap<>();

        data.put(
                "totalIncome",
                dashboardService.getTotalIncome()
        );

        data.put(
                "totalExpense",
                dashboardService.getTotalExpense()
        );

        data.put(
                "netBalance",
                dashboardService.getNetBalance()
        );
        return data;
    }

}
