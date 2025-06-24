const BASE_URL: string = "/api/v1/concerts";

@Injectable({ providedIn: "root" })
export class ConcertService = {
    
    constructor(private httpClient: HttpClient) {}
    
    public getConcerts(): Observable<ConcertDTO> {
        return this.httpClient.get(this.BASE_URL) as Observable<ConcertDTO[]>;
    }

    public createConcert(concert: ConcertDTO): Observable<ConcertDTO> {
        return this.httpClient.post(BASE_URL, concert) as Observable<AdDTO>;
    }
}