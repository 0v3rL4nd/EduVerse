import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { InstructorDashboardComponent } from './dashboard/instructor/instructor-dashboard.component';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';


@NgModule({
  declarations: [

    // any other components
  ],
  imports: [
    CommonModule,
    BrowserModule,
    HttpClientModule,
    MatTableModule,
    AppComponent,
    InstructorDashboardComponent,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    // any other modules
  ],
  providers: [],
  //bootstrap: [AppComponent]
})
export class AppModule { }
