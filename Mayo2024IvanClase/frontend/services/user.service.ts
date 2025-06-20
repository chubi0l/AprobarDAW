@Injectable
export class UserService {
    private role: string;

    // Se asume que el rol ya está asignado al loguearse

    getRole() {
        return this.role;
    }
}