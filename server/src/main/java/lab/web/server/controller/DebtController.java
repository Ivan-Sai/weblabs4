package lab.web.server.controller;

import lab.web.server.entities.GrossExtDebt;
import lab.web.server.services.DebtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RequestMapping("/api/debt")
public class DebtController {
        private final DebtService debtService;

        @GetMapping()
        public ResponseEntity<List<GrossExtDebt>> getDebtByDate(@RequestParam("date") String date) {
            return ResponseEntity.ok(debtService.getByDate(date));
        }

}
