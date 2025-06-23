const appRoutes: Routes = [
    { path: 'concerts', ConcertComponent },
    { path: '', redirectTo: 'concerts', pathMatch:'full'}
]

export const routing = RouterModule.forRoot(appRoutes);