import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Assignment {
  id: number;
  title: string;
  description: string;
  dueDate: string;
  courseTitle: string;
}

@Injectable({
  providedIn: 'root'
})
export class AssignmentService {
  private API_URL = 'http://localhost:8080/api/assignments';

  constructor(private http: HttpClient) {}

  getAllAssignments(): Observable<Assignment[]> {
    return this.http.get<Assignment[]>(this.API_URL);
  }
}
