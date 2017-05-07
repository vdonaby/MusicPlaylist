import {Injectable} from "@angular/core";


@Injectable()
export class Playlist {

    public playlistName: string;


    clear() {
        this.playlistName = null;
    }
}

