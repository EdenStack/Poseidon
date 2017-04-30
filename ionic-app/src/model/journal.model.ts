import {TrackModel} from './track.model';
export class JournalModel {
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
