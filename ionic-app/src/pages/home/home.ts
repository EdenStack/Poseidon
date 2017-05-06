import { Component, OnInit } from '@angular/core';
import { NavController } from 'ionic-angular';
import { HttpService } from '../../common/http.service';
import { DetailPage } from '../detail/detail'

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage implements OnInit {

  public recentJournalList: any;

  constructor(public navCtrl: NavController, public httpService: HttpService) {

  }

  ngOnInit(): void {
    this.httpService.get("recent")
      .subscribe(
      response => {
        this.recentJournalList = response;
      },
      error => {
        console.log("Error happens :" + error);
      }
      );
  }

  itemSelected(item) {
    this.navCtrl.push(DetailPage, { "item": item });
  }

}
