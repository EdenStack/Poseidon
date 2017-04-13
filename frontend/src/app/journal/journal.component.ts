import {Component, OnInit} from "@angular/core";
import "rxjs/Rx";
import {Journal} from "../model/journal.model";
import {HttpService} from "../common/http.service";

@Component({
  selector: 'app-journal',
  templateUrl: './journal.component.html',
  styleUrls: ['./journal.component.css']
})
export class JournalComponent implements OnInit {
  private journal: Journal = new Journal();

  constructor(public httpService: HttpService) {
  }

  ngOnInit() {
    this.testGet();
  }

  testGet() {
    this.httpService.get("/luoo/journal/666")
      .subscribe(
        response => {
          this.journal = response;
          console.log(this.journal);
        },
        error2 => {
          console.log(error2)
        }
      );
  }

}
