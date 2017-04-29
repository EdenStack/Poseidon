import {Component, OnInit} from '@angular/core';
import {NavController} from 'ionic-angular';
import {HttpService} from '../../common/http.service';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage implements OnInit {

  public recentJournal: any;

  constructor(public navCtrl: NavController, public httpService: HttpService) {

  }

  ngOnInit(): void {
    this.httpService.get("recent")
      .subscribe(
        response => {
          this.recentJournal = response;
        },
        error => {
          console.log(error)
        }
      );
  }

  itemSelected(item) {
    console.log(item);
  }

}
