package lab.web.server.services;

import lab.web.server.entities.GrossExtDebt;
import lab.web.server.repository.DebtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DebtGenerationService {
    private final DebtRepository debtRepository;

//    @Scheduled(fixedRate = 10000)
    public void generateDebt() {
        for (int i = 1; i <= 12; i++) {
            String date = i > 9 ? "2022" + i : "20220" + i;
            GrossExtDebt debt1 = new GrossExtDebt();
            debt1.setTxt("Сектор загальнодержавного управління. Короткострокові. Кредити та позики.");
            debt1.setDate(date);
            debt1.setTxten("General Government. Short-term. Loans.");
            debt1.setValue(randomDouble());
            GrossExtDebt debt2 = new GrossExtDebt();
            debt2.setDate(date);
            debt2.setTxt("Сектор загальнодержавного управління.");
            debt2.setTxten("General Government.");
            debt2.setValue(randomDouble());
            GrossExtDebt debt3 = new GrossExtDebt();
            debt3.setDate(date);
            debt3.setTxt("Центральний банк. Короткострокові. Валюта і депозити.");
            debt3.setTxten("Central Bank. Short-term. Currency and deposits.");
            debt3.setValue(randomDouble());
            GrossExtDebt debt4 = new GrossExtDebt();
            debt4.setDate(date);
            debt4.setTxt("Довідково. Прострочена заборгованість. Сектор загальнодержавного управління.");
            debt4.setTxten("Memorandum Item. Arrears. General Goverment.");
            debt4.setValue(randomDouble());
            GrossExtDebt debt5 = new GrossExtDebt();
            debt5.setDate(date);
            debt5.setTxt("Центральний банк.");
            debt5.setTxten("Central Bank.");
            debt5.setValue(randomDouble());
            GrossExtDebt debt6 = new GrossExtDebt();
            debt6.setDate(date);
            debt6.setTxt("Інші сектори. Короткострокові. Боргові цінні папери.");
            debt6.setTxten("Other sectors. Short-term. Debt securities.");
            debt6.setValue(randomDouble());
            debtRepository.save(debt1);
            debtRepository.save(debt2);
            debtRepository.save(debt3);
            debtRepository.save(debt4);
            debtRepository.save(debt5);
            debtRepository.save(debt6);
        }
        System.out.println("Debt generation service");
    }

    private Double randomDouble() {
        return Math.random() * 1000000;
    }
}
