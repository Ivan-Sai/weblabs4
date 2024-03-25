package lab.web.server.services;

import lab.web.server.entities.GrossExtDebt;

import java.util.List;

public interface DebtService {

    List<GrossExtDebt> getByDate(String date);
}
