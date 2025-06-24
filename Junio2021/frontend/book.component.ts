import { Component } from '@angular/core';
import { BookService } from './book.service';
import { BookDTO } from './book.dto';

@Component({
  templateUrl: 'book.component.html'
})
export class BookComponent {
  public searchTitle: string = '';
  public books: BookDTO[] = [];
  public searchPerformed: boolean = false;
  public loading: boolean = false;

  constructor(private bookService: BookService) {}

  public searchBooks(): void {
    this.loading = true;
    this.bookService.searchBooks(this.searchTitle).subscribe({
      next: result => {
        this.books = Array.isArray(result) ? result : [result].filter(book => book);
        this.searchPerformed = true;
        this.loading = false;
      },
      error: error => {
        console.error("Error en la búsqueda", error);
        this.books = [];
        this.searchPerformed = true;
        this.loading = false;
      }
    });
  }
}
