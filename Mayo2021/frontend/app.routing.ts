const appRoutes: Routes = [
    { path: 'room', component: RoomComponent },
    { path: '', redirectTo: 'rooms', pathMatch: 'full' }
]

export const routing = RouterModule.forRoot(appRoutes);