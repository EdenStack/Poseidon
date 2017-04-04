import {Component, OnInit} from '@angular/core';
import {JournalService} from "./journal.service";

@Component({
  selector: 'app-journal',
  templateUrl: './journal.component.html',
  styleUrls: ['./journal.component.css']
})
export class JournalComponent implements OnInit {
  somrthing: string;

  constructor(public journalService: JournalService) {
  }

  ngOnInit() {
    this.testGet();
  }

  testGet() {
    this.journalService.getTest().subscribe(
      response => this.somrthing = JSON.stringify(response),
      error2 => console.log(error2)
    );
  }

}
