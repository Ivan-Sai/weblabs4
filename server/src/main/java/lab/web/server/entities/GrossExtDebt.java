package lab.web.server.entities;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
public class GrossExtDebt extends BaseEntity{

    private String date;

    private String txt;

    private String txten;

    private Double value;

}