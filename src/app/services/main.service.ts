import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MainService {

  constructor(private http: HttpClient) {
  }

  getExternalDebt(date: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/debt?date=${date}` )
  }

}
