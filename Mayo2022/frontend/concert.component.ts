@Component({
  templateUrl: "app.component.html",
})
export class AppComponent implements OnInit {
  public concerts: ConcertDTO[];
  public concert: ConcertDTO;

  constructor(private concertService: ConcertService) {}

  ngOnInit() {
    this.loadConcerts();
  }

  public loadConcerts() {
    this.concertService.getConcerts().subscribe(
        (concertsList: ConcertDTO[]) => this.concerts = concertsList
    );
  }

  public createAd() {
    this.concertService.createConcert(this.concert).subscribe(
      () => this.loadConcerts(),
      () => alert("Error al crear el concierto"));
  }
}
