/**
 * Created by Tneciv on 2017/4/13.
 */
import {Injectable} from "@angular/core";
import {Http, RequestOptions, Response, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/Rx';

@Injectable()
export class HttpService {

  private BASE_URL = "http://localhost:8088/";
  private options: RequestOptions;

  constructor(private http: Http) {
    let headers = new Headers();
    localStorage.setItem("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNDkyOTUyMzE4fQ.r0n60AsW52WEVGkdc7LopENc5s7kuRJseITlw8nJLo4MmiE1RBhjzIIzuZhgZaaCcbjDpyyveafjTYEud2bWqA");
    let item = localStorage.getItem("Authorization");
    headers.append('Authorization', item);
    this.options = new RequestOptions({headers: headers});
  }

  get(url: string): Observable<any> {
    return this.http.get(this.BASE_URL + url, this.options)
      .map((res: Response) => res.json().content);
  }

  post(url: string, body: any): Observable<any> {
    return this.http.post(this.BASE_URL + url, body, this.options)
      .map((res: Response) => res.json());
  }

  put(url: string, body: any): Observable<any> {
    return this.http.put(this.BASE_URL + url, body, this.options)
      .map((res: Response) => res.json());
  }

  delete(url: string): Observable<any> {
    return this.http.delete(this.BASE_URL + url, this.options)
      .map((res: Response) => res.json());
  }

}
