import { Component, OnInit } from '@angular/core';
import {Assignment, AssignmentService} from '../../services/assignment.service';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';


@Component({
  selector: 'app-instructor-dashboard',
  templateUrl: './instructor-dashboard.component.html',
  styleUrls: ['./instructor-dashboard.component.scss']
})
export class InstructorDashboardComponent implements OnInit {

  assignments: Assignment[] = [];

  constructor(private assignmentService: AssignmentService) {}

  ngOnInit(): void {
    this.assignmentService.getAllAssignments().subscribe((data: Assignment[]) => {
      this.assignments = data;
    });
  }
}
