import { FunkoMainComponent } from "./funko-components/funko-main.component";

const appRoutes: Routes = [
    { path: "funkos", component: FunkoMainComponent },
    { path: "/admin", component: undefined},
    { path: "/buy/:id", component: undefined},
    { path: "", redirectoTo: "/funkos"}
]