import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/Rx';

@Injectable()
export class HttpService {

  private BASE_URL = "http://localhost:8080/journal/";

  constructor(public http: Http) {
  }

  get(url: string): Observable<any> {
    return this.http.get(this.BASE_URL + url)
      .map((res: Response) => res.json().content);
  }

}
