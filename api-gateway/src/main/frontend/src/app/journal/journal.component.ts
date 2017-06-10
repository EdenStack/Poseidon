import {Component, OnInit} from '@angular/core';
import {Http, RequestOptions, Headers} from '@angular/http';
import 'rxjs/Rx';

@Component({
  selector: 'app-journal',
  templateUrl: './journal.component.html',
  styleUrls: ['./journal.component.css']
})
export class JournalComponent implements OnInit {

  private options: RequestOptions;

  constructor(private http: Http) {
  }

  ngOnInit() {
    let headers = new Headers();
    localStorage.setItem("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNDk3OTczNjk2fQ.ZdSZiC1I0aGkfooK1INpufZQ2JQxA_EciG124Qeb8OwWA6mX8AMnZW0cr1y6_-TAyGSvpyKFEP56qwIeYjdT_w");
    let item = localStorage.getItem("Authorization");
    headers.append('Authorization', item);
    this.options = new RequestOptions({headers: headers});

    this.http.get('luoo/journal/keyword?keyword=民谣&pageSize=5&pageNum=1', this.options)
      .map(res => res.json())
      .subscribe(
        res => alert(res),
        err => alert(err)
      );
  }

}
