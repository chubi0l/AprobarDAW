import { FunkoDTO } from "../dtos/funkoDTO";

@Injectable
export class FunkoService {
    private BASE_URL: string = "/api/v1/funkos";

    constructor(private httpClient: HttpClient) {}
    
    getFunkos() Observable<FunkoDTO> {
        return this.httpClient.get(this.BASE_URL) as Observable<FunkoDTO[]>;
    }

    buyFunko(address: AddressDTO, funkoId: number) {
        return this.httpClient.post(this.BASE_URL + "/" + funkoId + "/address", address);
    }
}