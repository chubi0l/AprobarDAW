import { FunkoService } from "../services/funko.services";
import { UserService } from "../services/user.service";

@Component({
    selector: "funko-main",
    templateUrl: "funko-main.template.html"
})

export class FunkoMainComponent implements OnInit{
    public funkos: FunkoDTO[];
    public userRole: string;

    constructor(private funkoService: FunkoService, private userService: UserService, private router: Router) {}
    ngOnInit() {
        this.funkoService.getFunkos().subscribe(
            (funkos: FunkoDTO[]) => this.funkos = funkos,
            (error: any) => console.error(error)
        )
        this.userRole = this.userService.getRole()
    }

    goToBuy(funko: FunkoDTO) {
        this.router.navigate("/buy/" + funko.id);
    }
}