import {Component, OnInit} from '@angular/core';
import {MainService} from "../services/main.service";
import {FormsModule} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    NgIf
  ],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {

  selectedDate: string | undefined;

  displayedColumns: string[] = ['txt', 'txten', 'value'];

  array: any[] = [];

  error: boolean = false;
  noDateChosen: boolean = false;
  calc = 0;

  constructor(private service: MainService) {
  }

  loadData() {
    if (this.selectedDate) {
      this.noDateChosen = false;
      this.error = false;
      const formattedDate = this.formatDate(this.selectedDate);
      this.service.getExternalDebt(formattedDate).subscribe(
        data => {
          this.array = data;
          this.calc = 0;
          if (this.array.length === 0) {
            this.error = true;
          }
        }, error => {
        this.error = true;
        this.calc++;
        if (this.calc < 2) {
          this.loadData();
        }
        else {
          this.calc = 0;
        }
      },
      );
    } else {
      this.noDateChosen = true;
    }
  }

  formatDate(date: string): string {
    const [year, month] = date.split('-');
    return `${year}${month}`;
  }

}
