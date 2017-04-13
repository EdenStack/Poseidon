import {Headers, Http, RequestOptions} from '@angular/http';
import {Injectable} from '@angular/core';

@Injectable()
export class JournalService {
  constructor(public http: Http) {
  }

  getTest() {
    var headers = new Headers();
    headers.append('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNDkyMTgzNDg3f.Ic95X2-wRuM6Qd7G6KqUIndmucSOEa0AxynCRTTzXH_Ip1ZeZehWlfCcFi_1LKfRCuqf9mkkpNvpMu3jO_NusA');
    var options = new RequestOptions({headers: headers});
    return this.http.get('http://localhost:8088/music/journal/333', {headers: headers});
  }

}
