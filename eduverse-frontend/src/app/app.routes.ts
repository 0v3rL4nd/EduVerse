import { Routes } from '@angular/router';
import {InstructorDashboardComponent} from "./dashboard/instructor/instructor-dashboard.component";


export const routes: Routes = [
    {
        path: 'dashboard/instructor',
        component: InstructorDashboardComponent
    },
    // other routes...
];
