import { FunkoService } from "../services/funko.services"

@Component({
    templateUrl: "buy.template.html"
})

export class BuyComponent implements OnInit{
    public address: string
    public funkoId: number

    constructor(private router: Router, private funkoService: FunkoService) {}

    ngOnInit() {
        this.funkoId = // this.router.activatedRoute¿¿ buscar como sacar el id de la url
    }

    buyFunko() {
        this.funkoService.buyFunko(this.address, this.funkoId).subscribe(() => this.router.navigate("/"))
    }
}