package lab.web.server.services.impl;

import lab.web.server.entities.GrossExtDebt;
import lab.web.server.repository.DebtRepository;
import lab.web.server.services.DebtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DebtServiceImpl implements DebtService {

    private final DebtRepository debtRepository;
    @Override
    public List<GrossExtDebt> getByDate(String date) {
        return debtRepository.findByDate(date);
    }
}
