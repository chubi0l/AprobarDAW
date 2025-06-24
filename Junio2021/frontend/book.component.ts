import { BookService } from "./book.service";

@Component ({ 
    templateUrl: 'book.component.html'
})

export class BookComponent {
  public searchTitle: string = '';
  public books: BookDTO[] = [];
  public searchPerformed: boolean = false;

  constructor(private bookService: BookService) {}

  public searchBooks(): void {
    this.bookService.searchBooks(this.searchTitle).subscribe(result => {
      this.books = Array.isArray(result) ? result : [result].filter(book => book);
      this.searchPerformed = true;
    }, error => {
      console.error("Error en la búsqueda", error);
      this.books = [];
      this.searchPerformed = true;
    });
  }
}
