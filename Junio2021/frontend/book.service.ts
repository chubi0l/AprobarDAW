const BASE_URL = "api/v1/books";

@Injectable ({providedIn: 'root'})
export class BookService {
    public book: BookDTO;

    constructor (private httpClient: HttpClient) {}

    public searchBooks(String title): Observable<BookDTO[]> {
        return this.httpClient.get(BASE_URL + title) as Observable<BookDTO>;
    }
}