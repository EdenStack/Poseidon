import {TrackModel} from "./track.model";
/**
 * Created by Tneciv on 2017/4/13.
 */
export class Journal {
  title: string;
  keyWords: string;
  id: number;
  journalId: string;
  volCoverImg: string;
  relativeVols: string;
  volDate: string;
  volDesc: string;
  tracks: TrackModel[];
}
