import {Headers, Http, RequestOptions} from '@angular/http';
import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Journal} from "../model/journal.model";

@Injectable()
export class JournalService {
  constructor(public http: Http) {
  }

  getTest(): Observable<Journal> {
    var headers = new Headers();
    headers.append('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNDkyOTUyMzE4fQ.r0n60AsW52WEVGkdc7LopENc5s7kuRJseITlw8nJLo4MmiE1RBhjzIIzuZhgZaaCcbjDpyyveafjTYEud2bWqA');
    var options = new RequestOptions({headers: headers});
    return this.http.get('http://localhost:8088/luoo/journal/333', options)
      .map(res => res.json().content);
  }

}
