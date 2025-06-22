const BASE_URL = "/api/schedules/";

@Injectable({ providedIn: "root" })
export class RoomService {
  constructor(private httpClient: HttpClient) {}

  public getSchedules(): Observable<AdDTO[]> {
    return this.httpClient.get(BASE_URL) as Observable<RoomDTO[]>;
  }

  public reserveRoom(room: RoomDTO): Observable<RoomDTO> {
    return this.httpClient.put(BASE_URL + room.id, room) as Observable<RoomDTO>;
  }

  public cancelReserve(room: RoomDTO): Observable<RoomDTO> {
    return this.httpClient.put(BASE_URL + room.id, room) as Observable<RoomDTO>;
  }
}