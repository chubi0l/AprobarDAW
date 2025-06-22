@Component({
  selector: 'app-room',
  templateUrl: 'room.component.html',
  styleUrls: ['room.component.css']
})
export class RoomComponent {

  public hours: RoomDTO[] = [];
  public editingId: number | null = null;

  constructor(private roomService: RoomService) {}

  ngOnInit() {
    this.loadHours();
  }

  public loadHours() {
    this.roomService.getSchedules().subscribe(
      (hours: RoomDTO[]) => this.hours = hours
    );
  }

  public startReservation(room: RoomDTO) {
    this.editingId = room.id;
  }

  public saveReservation(room: RoomDTO) {
    if (!room.reserver || room.reserver.trim() === "") {
      alert("Introduce tu nombre");
      return;
    }
    room.free = false;
    this.roomService.reserveRoom(room).subscribe(() => {
      this.editingId = null;
      this.loadHours();
    });
  }

  public cancelReservation(room: RoomDTO) {
    if (confirm("¿Seguro que quieres anular la reserva?")) {
      this.roomService.cancelReserve(room.id!).subscribe(() => {
        this.loadHours();
      });
    }
  }
}
